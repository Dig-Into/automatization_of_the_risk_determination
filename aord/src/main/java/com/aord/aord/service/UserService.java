package com.aord.aord.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aord.aord.dto.LoginDTO;
import com.aord.aord.dto.LoginResponseDTO;
import com.aord.aord.dto.RegistrationDTO;
import com.aord.aord.dto.UserDTO;
import com.aord.aord.model.AppUser;
import com.aord.aord.model.enums.UserRoleName;

@Service
public interface UserService {

    void register(RegistrationDTO registrationDto, UserRoleName userRoleName);
    void checkLoginCredentials(AppUser user, String password);
    AppUser findByIdOrThrowException(Long id);
    LoginResponseDTO login(LoginDTO loginDTO);
    List<UserDTO> getAllUsers();
    void deleteUserById(Long id);
    UserDTO findUserByEmail(String email);
    void changePassword(Long id, String password);

}