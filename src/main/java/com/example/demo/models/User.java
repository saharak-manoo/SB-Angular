package com.example.demo.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @NotBlank
  @Email(message = "* Please Enter Valid Email Address")
  @NotEmpty(message = "* Please Provide Email Address")
  @Size(min = 3, max = 100)
  @Column(name = "email", unique = true)
  private String email;

  @NotBlank
  @NotEmpty(message = "* Please Enter password")
  @Size(min = 6, max = 100)
  @Column(name = "password")
  private String password;

  @Size(max = 50)
  @NotEmpty(message = "* Please Enter First Name")
  @Column(name = "first_name")
  private String firstName;

  @Size(max = 50)
  @NotEmpty(message = "* Please Enter Last Name")
  @Column(name = "last_name")
  private String lastName;
}