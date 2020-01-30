package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import javax.validation.Valid;

@RestController
public class UserController extends ApplicationController {
  @Autowired
  private UserService userService;

  @GetMapping("users")
  public List<User> all() {
    return userService.all();
  }

  @GetMapping("/users/{id}")
  public ResponseEntity<User> showUser(@PathVariable Long id) {
    return ResponseEntity.ok(userService.findById(id));
  }

  @PostMapping("/users")
  public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
    return ResponseEntity.ok(userService.save(user));
  }

  @PutMapping("/users/{id}")
  public ResponseEntity<User> updateUser(@Valid @RequestBody User user, @PathVariable(value = "id") Long id) {
    return ResponseEntity.ok(userService.update(user, id));
  }

  @DeleteMapping("/users/{id}")
  public ResponseEntity<?> deleteUser(@PathVariable Long id) {
    Map<String, String> response = new HashMap<String, String>();
    if (userService.delete(id)) {
      response.put("status", "success");
      response.put("message", "user deleted successfully");
      return ResponseEntity.ok(response);
    } else {
      response.put("status", "error");
      response.put("message", "Something went wrong when delete the user");
      return ResponseEntity.status(500).body(response);
    }
  }
}