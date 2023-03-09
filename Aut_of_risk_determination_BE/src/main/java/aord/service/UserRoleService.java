package aord.service;

import org.springframework.stereotype.Service;

import aord.model.UserRole;
import aord.model.enums.UserRoleName;

@Service
public interface UserRoleService {
	
	public UserRole getUserRole(UserRoleName userRoleName);
}
