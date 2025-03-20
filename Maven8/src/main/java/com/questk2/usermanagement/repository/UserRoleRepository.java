package com.questk2.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.questk2.usermanagement.entity.UserRole;
import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

    
    List<UserRole> findByUserId(Integer userId);
}
