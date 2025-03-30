package com.questk2.controller;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.questk2.dto.UserAuthData;
import com.questk2.dto.UserRoleRequest;
import com.questk2.entity.User;
import com.questk2.entity.UserRole;
import com.questk2.repository.UserRepository;
import com.questk2.repository.UserRoleRepository;
import com.questk2.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
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
	Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private UserRoleRepository userRoleRepository;
    
    @Autowired
    private UserService userService;
    
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
		logger.info("find all the users");
		List<User> users = null;
		logger.info("Started getting all the user ");
		try {
			users = userService.getAllUsers();
			logger.info("got the list of user");
		} catch (Exception e) {
			logger.error("exception occurd while getting all users",e);
			throw e ;
		}
		return users;
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
    	if (null == userRoleRequest) {
			throw new IllegalArgumentException("userRoleRequest should not be null");
		}
    	String userName = userRoleRequest.getUserName();
    	if (null == userName) {
			throw new IllegalArgumentException("userName should not be null");
		}
    	String password = userRoleRequest.getPassword();
		if (null == password) {
			throw new IllegalArgumentException("password should not be null");
		}
		logger.info("Started saving the user ");
		User user = null;
		try {
			user = userService.createUserWithRole(userRoleRequest);
			logger.info("Finished saving the user ");
		} catch (Exception e) {
			logger.info("Error while saving the user", e);
			throw e;
		}

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
    	if (null == userRoleRequest) {
			throw new IllegalArgumentException("userRoleRequest should not be null");
		}
    	String userName = userRoleRequest.getUserName();
    	if (null == userName) {
			throw new IllegalArgumentException("userName should not be null");
		}
    	String password = userRoleRequest.getPassword();
		if (null == password) {
			throw new IllegalArgumentException("password should not be null");
		}
		logger.info("Started update the user ");
		User user = null;
		try {
			user = userService.updateUser(id, userRoleRequest);
			logger.info("Finished saving the user ");
		} catch (Exception e) {
			logger.info("Error while update the user", e);
			throw e;
		}

		return user;
    }
    
    
	/**
	 * Authenticate the users for the provided userName and password
	 * 
	 * @param userName
	 * @param pwd
	 * 
	 * @throws Exception
	 * @{@link Return} user
	 */
    @Operation(summary = "Authenticate the users for the provided userName and password", description = "Authenticate the users for the provided userName and password")
    @ApiResponse(responseCode = "200", description = "Users  found.")
    @ApiResponse(responseCode = "404", description = "No users found.")
    @ApiResponse(responseCode = "500", description = "Internal server error.")
    @PostMapping("/authenticate")
	public User authenticate(@RequestBody UserAuthData authData) {
		
    	if (null == authData) {
			throw new IllegalArgumentException("authData should not be null");
		}
    	String userName = authData.getUserName();
    	String pwd = authData.getPwd();
    	if (null == userName) {
			throw new IllegalArgumentException("userName should not be null");
		}
		if (null == pwd) {
			throw new IllegalArgumentException("pwd should not be null");
		}
		logger.info("Started authenticating the user in authenticate(). Username :" + userName + ", password :" + pwd);
		User user = null;
		try {
			user = userService.authenticate(userName, pwd);
		} catch (Exception e) {
			logger.info("Error while authenticating the user in authenticate(). Username :" + userName + ", password :"
					+ pwd, e);
			throw e;
		}

		return user;
	}
}
