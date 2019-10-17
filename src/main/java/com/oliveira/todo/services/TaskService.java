package com.oliveira.todo.services;

import java.util.Optional;

import com.oliveira.todo.model.Task;
import com.oliveira.todo.repository.TaskRepository;
import com.oliveira.todo.services.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

  @Autowired
  private TaskRepository repo;

  public Task findById(Integer id) {
    Optional<Task> obj = repo.findById(id);
    return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
  }

  // public List<Task> findByTitle(String text) {
  //   return repo.searchTitle(text);
  // }
}