package com.aord.aord.controller;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aord.aord.dto.LoginDTO;
import com.aord.aord.dto.LoginResponseDTO;
import com.aord.aord.dto.RegistrationDTO;
import com.aord.aord.dto.UserDTO;
import com.aord.aord.model.enums.UserRoleName;
import com.aord.aord.service.UserService;

@RestController
@RequestMapping(value = "user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "users")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public List<UserDTO> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "by_email")
    public UserDTO getUserByEmail(@RequestParam(value = "email", required = false) String email) {
        return userService.findUserByEmail(email);

    }

    @PostMapping(value = "/register/user")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public ResponseEntity<Object> newUser(@RequestBody @Valid RegistrationDTO registrationDto) {
        userService.register(registrationDto, UserRoleName.ROLE_USER);
        return new ResponseEntity<>(CREATED);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid LoginDTO loginDto) {
        return new ResponseEntity<>(userService.login(loginDto), CREATED);
    }

    @DeleteMapping("id")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public void deleteUserById(@RequestParam Long id) {
        userService.deleteUserById(id);
    }

    @PostMapping("change_password/{id}")
    public void changePasswordForUser(@PathVariable Long id,
                                      @RequestParam String password){
        userService.changePassword(id, password);
    }

}