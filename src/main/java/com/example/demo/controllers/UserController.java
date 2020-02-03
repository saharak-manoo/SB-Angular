package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController extends ApplicationController {
  @Autowired
  private UserService userService;

  @GetMapping("users")
  public ResponseEntity<?> all() {
    Map<String, List<User>> response = new HashMap<String, List<User>>();
    response.put("users", userService.all());

    return ResponseEntity.ok(response);
  }

  @GetMapping("/users/{id}")
  public ResponseEntity<?> showUser(@PathVariable Long id) {
    Map<String, User> response = new HashMap<String, User>();
    User user = userService.findById(id);
    if (user != null) {
      response.put("user", user);

      return ResponseEntity.ok(user);
    } else {
      response.put("user", user);

      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
  }

  @PostMapping("/users")
  public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
    Map<String, User> response = new HashMap<String, User>();
    User newUser = userService.save(user);
    if (newUser != null) {
      response.put("user", newUser);

      return ResponseEntity.ok(response);
    } else {
      response.put("user", newUser);

      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
  }

  @PutMapping("/users/{id}")
  public ResponseEntity<?> updateUser(@Valid @RequestBody User user, @PathVariable(value = "id") Long id) {
    Map<String, User> response = new HashMap<String, User>();
    User updateUser = userService.update(user, id);
    if (updateUser != null) {
      response.put("user", updateUser);
      
      return ResponseEntity.ok(response);
    } else {
      response.put("user", updateUser);

      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
  }

  @DeleteMapping("/users/{id}")
  public ResponseEntity<?> deleteUser(@PathVariable Long id) {
    Map<String, String> response = new HashMap<String, String>();
    if (userService.delete(id)) {
      response.put("message", "user deleted successfully");
      return ResponseEntity.ok(response);
    } else {
      response.put("message", "Something went wrong when delete the user");
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
  }
}