package com.example.demo.services;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("userService")
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public User findUserByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  public User findUserById(Long id) {
    return userRepository.findById(id).orElse(null);
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User saveUser(User user) {
    return userRepository.save(user);
  }

  public User updateUser(User user, Long id) {
    User updateUser = userRepository.findById(id).orElse(null);
    if (updateUser != null) {
      updateUser.setFirstName(user.getFirstName());
      updateUser.setLastName(user.getLastName());
    }
    userRepository.save(updateUser);
    return updateUser;
  }

  public Boolean deleteUser(Long id) {
    User delUser = userRepository.findById(id).orElse(null);
    if (delUser != null) {
      userRepository.delete(delUser);
      return true;
    }
    return false;
  }
}