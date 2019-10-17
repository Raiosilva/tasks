package com.oliveira.todo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity(name = "task")
public class Task implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private Date date;
  private String text;
  private Boolean done;
  // private AuthorDTO author;

  // @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  public Task() { }

  public Task(int id, Date date, String text, Boolean done, User user) {
    super();
    this.id = id;
    this.date = date;
    this.text = text;
    this.done = done;
    this.user = user;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Boolean getDone() {
    return done;
  }

  public void setDone(Boolean done) {
    this.done = done;
  }

  // public AuthorDTO getAuthor() {
  //   return author;
  // }

  // public void setAuthor(AuthorDTO author) {
  //   this.author = author;
  // }

  public User getUser() {
    return user;
  }
  
  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Task other = (Task) obj;
    if (id != other.id)
      return false;
    return true;
  }
}