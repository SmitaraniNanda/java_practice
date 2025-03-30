package com.questk2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.questk2.entity.User;
import com.questk2.entity.UserRole;

/**
 * Repository interface for managing UserRole entities.
 * This interface provides CRUD operations for the UserRole table.
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    /**
     * Finds a UserRole by the associated User.
     *
     * @param user The User entity for which the role is to be fetched.
     * @return An Optional containing the UserRole if found, otherwise empty.
     */
    Optional<UserRole> findByUser(User user);
    Optional<UserRole> findByUserId(Long userId);
}
