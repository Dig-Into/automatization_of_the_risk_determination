package com.aord.aord.service.impl;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aord.aord.service.UserRoleService;
import com.aord.aord.model.UserRole;
import com.aord.aord.model.enums.UserRoleName;
import com.aord.aord.repository.UserRoleRepository;

@Service
public class UserRoleServiceImpl implements UserRoleService{
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