package com.guneet.User.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guneet.User.service.UserService;
import com.guneet.User.service.UserServiceImpl;
import com.guneet.User.shared.UserDto;
import com.guneet.User.ui.model.CreateRequestModel;
import com.guneet.User.ui.model.CreateResponseModel;

@RestController
@RequestMapping("/users")
public class UserController {
	
	// create user (sign up)
	// user login (sign in)
	// get user details
	// update user
	// delete user
	
	public static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/hello")
	private String welcome() {
		return "hello";
	}
	
	@GetMapping("/status/check")
	private String status() {
		log.info("users status check");
		return "working on port " + env.getProperty("local.server.port");
	}
	
	@PostMapping
	public ResponseEntity<CreateResponseModel> createUser(@Valid @RequestBody CreateRequestModel userDetails) {
		log.info("inside users controller");
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		UserDto userDto =  modelMapper.map(userDetails, UserDto.class);
		
		UserDto createUser = userService.createUser(userDto);
		
		CreateResponseModel returnValue = modelMapper.map(createUser,CreateResponseModel.class); 
		
		return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
	}
	
}
