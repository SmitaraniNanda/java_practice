package com.questk2.service;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questk2.dto.UserRoleRequest;
import com.questk2.entity.User;
import com.questk2.entity.UserRole;
import com.questk2.repository.UserRepository;
import com.questk2.repository.UserRoleRepository;

@Service
public class UserService {
	Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserRoleRepository userRoleRepository;

	/**
	 * Authenticate the users for the provided userName and password
	 * 
	 * @param userName
	 * @param pwd
	 * 
	 * @throws Exception
	 * @return user
	 */
	public User authenticate(String userName, String pwd) {
		if (null == userName) {
			throw new IllegalArgumentException("userName should not be null");
		}
		if (null == pwd) {
			throw new IllegalArgumentException("pwd should not be null");
		}
		logger.info("Started authenticating the user in authenticate(). Username :" + userName + ", password :" + pwd);
		User user = null;
		try {
			user = userRepository.findByUserNameAndPassword(userName, pwd);
			if (user == null) {
				logger.info("User not found for  Username :" + userName + ", password :" + pwd);
			} else {
				logger.info("User found for  Username :" + userName + ", password :" + pwd);
			}
			logger.info("Finished authenticating the user in authenticate(). ");
		} catch (Exception e) {
			logger.info("Error while authenticating the user in authenticate(). Username :" + userName + ", password :"
					+ pwd);
			throw e;
		}
		return user;
	}

	/**
	 * Creates a new user along with an associated role.
	 * 
	 * @param userRoleRequest DTO containing user details and role information.
	 * @return The newly created user.
	 */
	public User createUserWithRole(UserRoleRequest userRoleRequest) {

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
			user = new User();
			user.setUserName(userRoleRequest.getUserName());
			user.setPassword(userRoleRequest.getPassword());
			user.setName(userRoleRequest.getName());
			user.setEmail(userRoleRequest.getEmail());
			user.setPhoneNumber(userRoleRequest.getPhoneNumber());
			user.setDepartment(userRoleRequest.getDepartment());
			user = userRepository.save(user);
			
			Set<String> roles = userRoleRequest.getRoles();
            for(String role : roles) {
            	UserRole userRole = new UserRole(user, role);
    			userRoleRepository.save(userRole);
            }
			logger.info("Finished saving the user ");
		} catch (Exception e) {
			logger.info("Error while saving the user", e);
			throw e;
		}

		return user;
	}
	
	/**
	 * Creates a new user along with an associated role.
	 * 
	 * @param userRoleRequest DTO containing user details and role information.
	 * @return The newly created user.
	 */
	public User updateUser(Long id, UserRoleRequest userRoleRequest) {

		if (null == id) {
			throw new IllegalArgumentException("id should not be null");
		}
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
		User updateUser = null;
		try {
			updateUser = userRepository.findById(id).map(user -> {
	            user.setDepartment(userRoleRequest.getDepartment());
	            user.setEmail(userRoleRequest.getEmail());
	            user.setUserName(userRoleRequest.getUserName());
	            user.setPassword(userRoleRequest.getPassword());
	            user.setPhoneNumber(userRoleRequest.getPhoneNumber());
	            user.setName(userRoleRequest.getName());
	            User updatedUser = userRepository.save(user);
	            Set<String> roles = userRoleRequest.getRoles();
	            for(String role : roles) {
	            	UserRole userRole = userRoleRepository.findByUser(updatedUser).orElse(new UserRole(updatedUser, role));
	                userRole.setRole(role);
	                userRoleRepository.save(userRole);
	            }
	            return updatedUser;
	        }).orElseThrow(() -> new RuntimeException("User not found: " + id));
			logger.info("Finished saving the user ");
		} catch (Exception e) {
			logger.info("Error while update the user", e);
			throw e;
		}
		return updateUser;
	}

	public List<User> getAllUsers() {
		List<User> users= null;
		try {
			 users= userRepository.findAll();
		} catch (Exception e) {
			logger.error("exception occur while getting all users",e);
			throw e;
		}
		return users;
	}

}
