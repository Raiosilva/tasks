package com.oliveira.todo.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.oliveira.todo.controller.dto.UserDTO;
import com.oliveira.todo.model.Task;
import com.oliveira.todo.model.User;
import com.oliveira.todo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value="/users")
public class UserController {

  @Autowired
  private UserService service;

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<UserDTO>> findAll() {
      List<User> list = service.findAll();
      List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
      return ResponseEntity.ok().body(listDto);
  }

  @RequestMapping(value="/{id}", method = RequestMethod.GET)
  public ResponseEntity<UserDTO> findById(@PathVariable Integer id) {
      User obj = service.findById(id);
      return ResponseEntity.ok().body(new UserDTO(obj));
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
      User obj = service.fromDTO(objDto);
      obj = service.insert(obj);
      URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
  }

  @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Void> delete(@PathVariable Integer id) {
      service.delete(id);
      return ResponseEntity.noContent().build();
  }

  @RequestMapping(value="/{id}", method = RequestMethod.PUT)
  public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable Integer id) {
      User obj = service.fromDTO(objDto);
      obj.setId(id);
      obj = service.update(obj);
      return ResponseEntity.noContent().build();
  }

  @RequestMapping(value="/{id}/tasks", method = RequestMethod.GET)
  public ResponseEntity<List<Task>> findTasks(@PathVariable Integer id) {
      User obj = service.findById(id);
      return ResponseEntity.ok().body(obj.getTasks());
  }

}