package com.oliveira.todo.repository;

import com.oliveira.todo.model.Task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

  // List<Task> searchTitle(String text);

  // List<Task> findByTitleContainsIgnoreCase(String text);

  // // @Query("")
  // List<Task> fullSearch(String text, Date minDate, Date maxDate);

}