package com.oliveira.todo.controller.dto;

import java.io.Serializable;

import com.oliveira.todo.model.User;

public class AuthorDTO implements Serializable {
  private static final long serialVersionUID = 1L;

  private int id;
  private String name;

  public AuthorDTO() {
  }

  public AuthorDTO(User obj) {
    id = obj.getId();
    name = obj.getName();
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
}