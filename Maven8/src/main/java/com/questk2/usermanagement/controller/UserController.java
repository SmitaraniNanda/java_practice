package com.questk2.usermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.questk2.usermanagement.entity.User;
import com.questk2.usermanagement.repository.UserRepository;


@RestController
public class UserController {
	@Autowired
	UserRepository repo;
@GetMapping("/user")
public List<User>getAllUser(){
	List<User>user=repo.findAll();
	return user;
}
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable int id) {
		User user=repo.findById(id).get();
		return user;
		
	}
	@PostMapping("/user/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void createStudent(@RequestBody User user) {
		repo.save(user);
		
	}
	@PutMapping("/user/update/{id}")
	public User  updateUser(@PathVariable int id) {
	User user= repo.findById(id).get();
	user.setName("Smita");
	user.setId(80);
	repo.save(user);
		return user;
	}
	@DeleteMapping("/user/delete/{id}")
	public void removeStudent(@PathVariable int id) {
		User user=repo.findById(id).get();
		repo.delete(user);
	}
}

