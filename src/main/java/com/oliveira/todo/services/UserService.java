package com.oliveira.todo.services;

import java.util.List;
import java.util.Optional;

import com.oliveira.todo.controller.dto.UserDTO;
import com.oliveira.todo.model.User;
import com.oliveira.todo.repository.UserRepository;
import com.oliveira.todo.services.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository repo;

  public List<User> findAll(){
    return repo.findAll();
  }

  public User findById(Integer id) {
    Optional<User> obj = repo.findById(id);
    return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
  }

  public User insert(User obj) {
    return repo.save(obj);
  }

  public void delete(Integer id) {
    findById(id);
    repo.deleteById(id);
  }

  public User update(User obj) {
    User newObj = findById(obj.getId());
    updateData(newObj, obj);
    return repo.save(newObj);
  }

  private void updateData(User newObj, User obj) {
    newObj.setName(obj.getName());
    newObj.setEmail(obj.getEmail());
  }

  public User fromDTO(UserDTO objDto) {
    return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
  }
}