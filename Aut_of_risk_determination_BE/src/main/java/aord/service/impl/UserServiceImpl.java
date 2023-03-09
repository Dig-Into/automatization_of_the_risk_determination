package aord.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import aord.converter.UserToUserDTOConverter;
import aord.dto.LoginDTO;
import aord.dto.LoginResponseDTO;
import aord.dto.RegistrationDTO;
import aord.dto.UserDTO;
import aord.model.JWT;
import aord.model.User;
import aord.model.UserRole;
import aord.model.enums.UserRoleName;
import aord.repository.JWTRepository;
import aord.repository.UserRepository;
import aord.service.JWTService;
import aord.service.UserRoleService;
import aord.service.UserService;
import aord.service.exception.util.ExceptionMessages;
import aord.service.exception.EmailAlreadyExistsException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final UserRoleService userRoleService;
	private final JWTService jwtService;
	
	@Autowired
	private UserToUserDTOConverter converter;
	
	@Autowired
	private JWTRepository jwtRepo;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder,
			UserRoleService userRoleService, JWTService jwtService) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.userRoleService = userRoleService;
		this.jwtService = jwtService;
	}

	@Override
	public void checkLoginCredentials(User user, String password) {
		// TODO Auto-generated method stub

	}

	public static Collection<? extends GrantedAuthority> getAuthorities(UserRoleName userRole) {
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(userRole.toString()));
		return authorities;
	}

	public User findByIdOrThrowException(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(ExceptionMessages.EMAIL_DOES_NOT_EXIST));
	}

	@Override
	public void register(RegistrationDTO registrationDto, UserRoleName userRoleName) {
		if (userRepository.findByEmail(registrationDto.getEmail()).isPresent()) {
			log.error("User with the provided email '{}' already exists!", registrationDto.getEmail());
			throw new EmailAlreadyExistsException(ExceptionMessages.EMAIL_ALREADY_EXISTS);
		}

		UserRole userRole = userRoleService.getUserRole(userRoleName);

		this.userRepository.save(User.builder().email(registrationDto.getEmail()).userRole(userRole)
				.password(passwordEncoder.encode(registrationDto.getPassword())).build());

	}

	@Override
	public LoginResponseDTO login(LoginDTO loginDTO) {
		Optional<User> userOptional = userRepository.findByEmail(loginDTO.getEmail());
		if (!userOptional.isPresent()) {
			throw new BadCredentialsException(ExceptionMessages.INVALID_CREDENTIALS_MESSAGE);
		}

		User user = userOptional.get();

		if (!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
			log.error("User with id '{}' provided passwords which do not match ", user.getId());
			throw new BadCredentialsException(ExceptionMessages.INVALID_CREDENTIALS_MESSAGE);
		}

		return new LoginResponseDTO(jwtService.createToken(user));
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> users = userRepository.findAll();
		List<UserDTO> ret = new ArrayList<>();
		for(User user:users) {
			ret.add(converter.userToUserDTO(user));
		}
		
		return ret;
	}

	@Override
	public void deleteUserById(Long id) {
		User user = userRepository.getById(id);
		if(user != null) {
			List<JWT> jwtList = jwtRepo.findAll();
			for(JWT jwt: jwtList) {
				User target = jwt.getUser();
				if(target != null && Objects.equals(target.getId(), id)) {
					jwtRepo.deleteById(jwt.getId());
				}
			}
		}
		
		userRepository.deleteById(id);
		
	}

	@Override
	public void changePassword(Long id, String password) {
		Optional<User> target = userRepository.findById(id);
		User user = null;
		if(target.isPresent() && target != null) {
			user = target.get();
			if(user != null) {
				user.setPassword(passwordEncoder.encode(password));
				userRepository.save(user);
			}
			
		}
		
	}

	@Override
	public List<UserDTO> getOnlyUsers() {
		List<User> users = userRepository.findAll();
		List<UserDTO> ret = new ArrayList<>();
		for(User user:users) {
			UserRole role = user.getUserRole();
			UserRoleName name = role.getName();
			if( name.name() == "ROLE_USER" ) {
				ret.add(converter.userToUserDTO(user));
			}
			
		}
		
		return ret;
		
	}

	@Override
	public UserDTO findUserByEmail(String email) {
		Optional<User> userOptinal = userRepository.findByEmail(email);
		User user = null;
		UserDTO userDTO = null;
		if(userOptinal.isPresent()) {
			user = userOptinal.get();
			if(user != null) {
				userDTO = converter.userToUserDTO(user);
			}
		}
		
		return userDTO;
	}

}
