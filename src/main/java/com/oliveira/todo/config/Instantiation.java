package com.oliveira.todo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import com.oliveira.todo.model.Task;
import com.oliveira.todo.model.User;
import com.oliveira.todo.repository.TaskRepository;
import com.oliveira.todo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Instantiation implements CommandLineRunner {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private TaskRepository taskRepository;

  @Override
  public void run(String... args) throws Exception {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

    userRepository.deleteAll();
    taskRepository.deleteAll();

    User maria = new User(1, "Maria Oliveira", "maria@gmail.com");
    User raimundo = new User(2, "Raimundo Oliveira", "raimundooliveira@gmail.com");
    User cecilia = new User(3, "Cecília Oliveira", "grazi@gmail.com");

    userRepository.saveAll(Arrays.asList(maria, raimundo, cecilia));

    Task task1 = new Task(1, sdf.parse("15/10/2019"), "Compras", true, maria );
    Task task2 = new Task(2, sdf.parse("16/10/2019"), "Aula de Zumba", false, maria );

    taskRepository.saveAll(Arrays.asList(task1, task2));

    maria.getTasks().addAll(Arrays.asList(task1, task2));
    userRepository.save(maria);
  }
}