package com.aord.aord.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aord.aord.model.UserRole;
import com.aord.aord.model.enums.UserRoleName;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long>{
    Optional<UserRole> findByName(UserRoleName name);
}
