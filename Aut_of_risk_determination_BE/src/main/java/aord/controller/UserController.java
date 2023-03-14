package aord.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

import java.util.List;

import javax.validation.Valid;

import aord.dto.LoginDTO;
import aord.dto.LoginResponseDTO;
import aord.dto.RegistrationDTO;
import aord.dto.UserDTO;
import aord.model.enums.UserRoleName;
import aord.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "user")

public class UserController {
	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping(value = "users")
	@PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN','ROLE_ADMIN')")
	public List<UserDTO> getUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping(value = "by_email")
	public UserDTO getUserByEmail(@RequestParam(value = "email", required = false) String email) {
		return userService.findUserByEmail(email);
		
	}

	@PostMapping(value = "/register/regular")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public ResponseEntity<Object> register(@RequestBody @Valid RegistrationDTO registrationDto) {
		userService.register(registrationDto, UserRoleName.ROLE_USER);
		return new ResponseEntity<>(CREATED);
	}


	@PostMapping(value = "/login")
	public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid LoginDTO loginDto) {
		return new ResponseEntity<>(userService.login(loginDto), CREATED);
	}
	
	@PostMapping("change_password/{id}")
	public void changePasswordForUser(@PathVariable Long id,
			@RequestBody String password){
		userService.changePassword(id, password);
	}
	
	@DeleteMapping("id")
	@PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN','ROLE_ADMIN')")
	public void deleteUserById(@RequestParam Long id) {
		userService.deleteUserById(id);
	}

}