package com.restaurant.controller;


import com.restaurant.DTO.UserDTO;
import com.restaurant.constant.Webconstant;
import com.restaurant.requestwrapper.UserLoginRequestWrapper;
import com.restaurant.requestwrapper.UserRequestWrapper;
import com.restaurant.service.UserService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.restaurant.formatter.ResponseFormatter;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/user")
public class UserController {

	@Autowired
	private UserService userService;


	@PostMapping(value ="/register")
	public ResponseEntity<JSONObject> addUser(
			 @RequestBody UserRequestWrapper request
)  {

	System.out.println("add user Start");
		System.out.println(request.getEmail()
		);
	userService.createUser(request);
	JSONObject data = ResponseFormatter.formatter(Webconstant.KEY_STATUS_SUCCESS, 200, "message");

	System.out.println("add user end");

	return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@PostMapping(value ="/login")
	public ResponseEntity<JSONObject> login(
			@RequestBody UserLoginRequestWrapper userLoginRequestWrapper
			)  {

		System.out.println("login user Start");

		boolean user= userService.login(userLoginRequestWrapper);
		JSONObject data = ResponseFormatter.formatter(Webconstant.KEY_STATUS_SUCCESS, 200, "Login Successful",user);

		System.out.println("login user end");

		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	@GetMapping(value ="/userLogged")
	public ResponseEntity<JSONObject> getUserLogged()  {

		System.out.println("get login user Start");

		UserDTO user= userService.getUserLogged();
		JSONObject data = ResponseFormatter.formatter(Webconstant.KEY_STATUS_SUCCESS, 200, "User LoggedIn ",user);

		System.out.println(" get login user end");

		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	
}
