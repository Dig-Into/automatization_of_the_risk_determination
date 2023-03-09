package aord.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import aord.dto.UserDTO;
import aord.model.User;

@Component
public class UserToUserDTOConverter implements Converter<UserDTO, User> {
	
	@Override
	public User convert(UserDTO source) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public UserDTO userToUserDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setName(user.getEmail());
		userDTO.setPassword(user.getPassword());
		
		return userDTO;
	}

}
