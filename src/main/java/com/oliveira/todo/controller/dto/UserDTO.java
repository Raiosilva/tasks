package com.oliveira.todo.controller.dto;

import java.io.Serializable;

import com.oliveira.todo.model.User;

public class UserDTO implements Serializable {
  private static final long serialVersionUID = 1L;

  private int id;
  private String name;
  private String email;

  public UserDTO() {}

  public UserDTO(User obj) {
    id = obj.getId();
    name = obj.getName();
    email = obj.getEmail();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}