package com.aord.aord.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.aord.aord.dto.UserDTO;
import com.aord.aord.model.AppUser;
import com.aord.aord.model.enums.UserRoleName;

@Component
public class ToUserConverter implements Converter<UserDTO, AppUser> {

    @Override
    public AppUser convert(UserDTO source) {
        AppUser userNew = new AppUser();
        userNew.setId(source.getId());
        userNew.setPassword(source.getPassword());
        userNew.setEmail(source.getName());
        return userNew;
    }

    public UserDTO userToUserDTO(AppUser user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getEmail());
        userDTO.setPassword(user.getPassword());
        UserRoleName userRole = user.getUserRole().getName();

        if (userRole.name().equals("ROLE_USER")) {
            userDTO.setUserRole("User");
        }

        else if (userRole.name().equals("ROLE_ADMIN")) {
            userDTO.setUserRole("Admin");
        }
        else {
            userDTO.setUserRole(userRole.name());
        }
        return userDTO;
    }
}