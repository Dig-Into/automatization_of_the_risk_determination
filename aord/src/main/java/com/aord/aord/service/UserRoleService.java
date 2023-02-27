package com.aord.aord.service;

import org.springframework.stereotype.Service;

import com.aord.aord.model.UserRole;
import com.aord.aord.model.enums.UserRoleName;

@Service
public interface UserRoleService {
    public UserRole getUserRole(UserRoleName userRoleName);

}