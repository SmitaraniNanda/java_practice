package com.questk2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.questk2.entity.User;

/**
 * Repository interface for managing User entities.
 * This interface provides CRUD operations for the User table.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // JpaRepository provides built-in methods like save(), findById(), findAll(), deleteById(), etc.
}
