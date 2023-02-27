package aord.service;

import java.util.List;

import aord.dto.LoginDTO;
import aord.dto.LoginResponseDTO;
import aord.dto.RegistrationDTO;
import aord.dto.UserDTO;
import aord.model.User;
import aord.model.enums.UserRoleName;

public interface UserService {

	  void register(RegistrationDTO registrationDto, UserRoleName userRoleName);
//	  
//	  RegistrationTokenInfoDto validateToken(String tokenValue);
//	  
//	  AuthResponseDto login(LoginDto loginDto, HttpServletRequest request);
	  
//	  void logout(HttpServletRequest request, HttpServletResponse response);
	  
	  void checkLoginCredentials(User user, String password);
	  User findByIdOrThrowException(Long id);
	  LoginResponseDTO login(LoginDTO loginDTO);
	  List<UserDTO> getAllUsers();
	  List<UserDTO> getOnlyUsers();
	  void deleteUserById(Long id);
	  void changePassword(Long id, String password);
	  UserDTO findUserByEmail(String email);
	  
}
