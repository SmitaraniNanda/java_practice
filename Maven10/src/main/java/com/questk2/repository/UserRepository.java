package com.questk2.repository;

import com.questk2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for managing User entity database operations.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
    User findByUserNameAndPassword(String userName, String password);
}
