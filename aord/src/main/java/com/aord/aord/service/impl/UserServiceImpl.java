package com.aord.aord.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import jakarta.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.aord.aord.converter.ToUserConverter;
import com.aord.aord.dto.LoginDTO;
import com.aord.aord.dto.LoginResponseDTO;
import com.aord.aord.dto.RegistrationDTO;
import com.aord.aord.dto.UserDTO;
import com.aord.aord.model.JWT;
import com.aord.aord.model.AppUser;
import com.aord.aord.model.UserRole;
import com.aord.aord.model.enums.UserRoleName;
import com.aord.aord.repository.JWTRepository;
import com.aord.aord.repository.UserRepository;
import com.aord.aord.service.JWTService;
import com.aord.aord.service.UserRoleService;
import com.aord.aord.service.UserService;
import com.aord.aord.service.exception.EmailAlreadyExistsException;
import com.aord.aord.constant.UserLoginConstants;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRoleService userRoleService;
    private final JWTService jwtService;

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private ToUserConverter converter;

    @Autowired
    private JWTRepository jwtRepo;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, UserRoleService userRoleService, JWTService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRoleService = userRoleService;
        this.jwtService = jwtService;
    }

    @Override
    public void checkLoginCredentials(AppUser user, String password) {
        // Default constructor
    }

    //It was ? extends GrantedAuthority has to be tested!
    public static Collection<SimpleGrantedAuthority> getAuthorities(UserRoleName userRole) {
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(userRole.toString()));
        return authorities;
    }

    public AppUser findByIdOrThrowException(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(UserLoginConstants.EMAIL_DOES_NOT_EXIST));
    }

    @Override
    public void register(RegistrationDTO registrationDto, UserRoleName userRoleName) {
        if (userRepository.findByEmail(registrationDto.getEmail()).isPresent()) {
            log.error("User with the provided email already exists!");
            throw new EmailAlreadyExistsException(UserLoginConstants.EMAIL_ALREADY_EXISTS);
        }

        UserRole userRole = userRoleService.getUserRole(userRoleName);

        AppUser newUser = new AppUser();
        newUser.setEmail(registrationDto.getEmail());
        newUser.setUserRole(userRole);
        newUser.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        this.userRepository.save(newUser);

    }

    @Override
    public LoginResponseDTO login(LoginDTO loginDTO) {
        Optional<AppUser> userOptional = userRepository.findByEmail(loginDTO.getEmail());
        if (!userOptional.isPresent()) {
            throw new BadCredentialsException(UserLoginConstants.INVALID_CREDENTIALS_MESSAGE);
        }

        AppUser user = userOptional.get();

        if (!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            log.error("User with id '{}' provided passwords which do not match ", user.getId());
            throw new BadCredentialsException(UserLoginConstants.INVALID_CREDENTIALS_MESSAGE);
        }

        return new LoginResponseDTO(jwtService.createToken(user));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<AppUser> users = userRepository.findAll();
        List<UserDTO> ret = new ArrayList<>();
        for(AppUser user:users) {
            ret.add(converter.userToUserDTO(user));
        }

        return ret;
    }

    @Override
    public void deleteUserById(Long id) {
        AppUser user = userRepository.getById(id);
        if(ObjectUtils.isEmpty(user)) {
            //User shouldn't be empty
        }
        else {
            List<JWT> jwtList = jwtRepo.findAll();
            for(JWT jwt: jwtList) {
                AppUser target = jwt.getUser();
                if(target != null && Objects.equals(target.getId(), id)) {
                    jwtRepo.deleteById(jwt.getId());
                }
            }
        }
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO findUserByEmail(String email) {
        Optional<AppUser> userOptinal = userRepository.findByEmail(email);
        AppUser user = null;
        UserDTO userDTO = null;
        if(userOptinal.isPresent()) {
            user = userOptinal.get();
            if(user != null) {
                userDTO = converter.userToUserDTO(user);
            }
        }

        return userDTO;
    }

    @Override
    public void changePassword(Long id, String password) {
        Optional<AppUser> target = userRepository.findById(id);
        AppUser user = null;
        if(target.isPresent()) {
            user = target.get();
            if(user != null) {
                user.setPassword(passwordEncoder.encode(password));
                this.userRepository.save(user);
            }
        }
    }

}