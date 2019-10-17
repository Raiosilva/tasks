package com.oliveira.todo.controller;

import com.oliveira.todo.model.Task;
import com.oliveira.todo.services.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/tasks")
public class TaskController {

  @Autowired
  private TaskService service;

  @RequestMapping(value="/{id}", method = RequestMethod.GET)
  public ResponseEntity<Task> findById(@PathVariable Integer id) {
      Task obj = service.findById(id);
      return ResponseEntity.ok().body(obj);
  }

  // @RequestMapping(value="/titlesearch", method = RequestMethod.GET)
  // public ResponseEntity<List<Task>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
  //   text = URL.decodeParam(text);
  //   List<Task> list = service.findByTitle(text);
  //   return ResponseEntity.ok().body(list);
  // }
}