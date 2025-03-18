package com.questk2.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.questk2.usermanagement.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    // Additional query methods (if needed) can be added here
}
