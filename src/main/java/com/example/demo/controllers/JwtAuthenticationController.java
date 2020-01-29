package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

import com.example.demo.config.JwtTokenUtil;
import com.example.demo.models.JwtRequest;
import com.example.demo.models.JwtResponse;
import com.example.demo.models.User;
import com.example.demo.services.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class JwtAuthenticationController {
	@Autowired
	private UserService userService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@RequestMapping(value = "/sign_in", method = RequestMethod.POST)
	public ResponseEntity<?> generateAuthenticationToken(@RequestBody User user) throws Exception {
		final User currentUser = userService.findByEmail(user.getEmail());

		System.out.println("currentUser");
		System.out.println(currentUser);

		// final String token = jwtTokenUtil.generateToken(currentUser);
		// 	System.out.println("token");
		// System.out.println(token);

		return ResponseEntity.ok(currentUser);
	}
}
