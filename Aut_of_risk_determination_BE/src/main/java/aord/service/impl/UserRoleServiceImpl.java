package aord.service.impl;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aord.model.UserRole;
import aord.model.enums.UserRoleName;
import aord.repository.UserRoleRepository;
import aord.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {
	private final UserRoleRepository userRoleRepository;

	@Autowired
	public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
		this.userRoleRepository = userRoleRepository;
	}

	@Override
	public UserRole getUserRole(UserRoleName userRoleName) {
		return userRoleRepository.findByName(userRoleName).orElseThrow(EntityNotFoundException::new);
	}
}
