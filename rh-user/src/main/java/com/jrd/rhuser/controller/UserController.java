package com.jrd.rhuser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jrd.rhuser.entity.User;
import com.jrd.rhuser.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping
	public ResponseEntity<User>  save(User user) {
		User us = this.userService.create(user);
		
	  return ResponseEntity.ok(us);
	}

	@GetMapping("/{id}")	
	public ResponseEntity<User>  findByid(@PathVariable(value = "id")  Long id) {
	User userId =	this.userService.findById(id);
		
		return ResponseEntity.ok(userId);
	}
	
	@GetMapping("/search")
	public ResponseEntity<User> findEmail(@RequestParam String email) {
		User user = this.userService.findEmail(email);
		
		return ResponseEntity.ok(user);
	}
	

}
















