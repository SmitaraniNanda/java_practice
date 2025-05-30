package com.questk2.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.questk2.usermanagement.entity.User;
import com.questk2.usermanagement.entity.UserRole;

public interface UserRepository extends JpaRepository<User, Integer> {
    void save(UserRole userRole);
}
