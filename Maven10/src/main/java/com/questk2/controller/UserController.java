package com.questk2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.questk2.dto.UserRoleRequest;
import com.questk2.entity.User;
import com.questk2.entity.UserRole;
import com.questk2.repository.UserRepository;
import com.questk2.repository.UserRoleRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Controller class for managing user-related operations.
 * Provides APIs for fetching, creating, and updating users and their roles.
 */
@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@Tag(name = "User Controller", description = "APIs for managing users, including retrieval, creation, and updates.")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private UserRoleRepository userRoleRepository;
    
    /**
     * Retrieves a list of all users.
     * @return List of users.
     */
    @Operation(summary = "Retrieve all users", description = "Fetches all user details from the database.")
    @ApiResponse(responseCode = "200", description = "Users retrieved successfully.")
    @ApiResponse(responseCode = "404", description = "No users found.")
    @ApiResponse(responseCode = "500", description = "Internal server error.")
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    /**
     * Creates a new user along with an associated role.
     * @param userRoleRequest DTO containing user details and role information.
     * @return The newly created user.
     */
    @Operation(summary = "Create a new user", description = "Adds a new user with a specified role.")
    @ApiResponse(responseCode = "201", description = "User created successfully.")
    @ApiResponse(responseCode = "400", description = "Invalid user data.")
    @PostMapping("/users/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public User createUserWithRole(@RequestBody UserRoleRequest userRoleRequest) {
        User user = new User();
        user.setUserName(userRoleRequest.getUserName());
        user.setPassword(userRoleRequest.getPassword());
        user.setName(userRoleRequest.getName());
        user.setEmail(userRoleRequest.getEmail());
        user.setPhoneNumber(userRoleRequest.getPhoneNumber());
        user.setDepartment(userRoleRequest.getDepartment());
        user = userRepository.save(user);
        
        UserRole userRole = new UserRole(user, userRoleRequest.getRole());
        userRoleRepository.save(userRole);
        
        return user;
    }
    
    /**
     * Updates an existing user's details and role.
     * @param id The ID of the user to update.
     * @param userRoleRequest Updated user details and role information.
     * @return The updated user.
     */
    @Operation(summary = "Update an existing user", description = "Modifies user details and updates the associated role.")
    @ApiResponse(responseCode = "200", description = "User updated successfully.")
    @ApiResponse(responseCode = "404", description = "User not found.")
    @PutMapping("/users/update/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody UserRoleRequest userRoleRequest) {
        return userRepository.findById(id).map(user -> {
            user.setDepartment(userRoleRequest.getDepartment());
            user.setEmail(userRoleRequest.getEmail());
            user.setUserName(userRoleRequest.getUserName());
            user.setPassword(userRoleRequest.getPassword());
            user.setPhoneNumber(userRoleRequest.getPhoneNumber());
            user.setName(userRoleRequest.getName());
            
            User updatedUser = userRepository.save(user);
            
            UserRole userRole = userRoleRepository.findByUser(updatedUser).orElse(new UserRole(updatedUser, userRoleRequest.getRole()));
            userRole.setRole(userRoleRequest.getRole());
            userRoleRepository.save(userRole);
            
            return updatedUser;
        }).orElseThrow(() -> new RuntimeException("User not found: " + id));
    }
}
