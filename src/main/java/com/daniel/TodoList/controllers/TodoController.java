package com.daniel.TodoList.controllers;

import com.daniel.TodoList.models.Todo;
import com.daniel.TodoList.security.services.UserDetailsImpl;
import com.daniel.TodoList.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/todo")
public class TodoController {
    @Autowired
    TodoService todoService;

    @CrossOrigin
    @GetMapping()
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public List<Todo> getAllTodo(){
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return todoService.getAllTodos(userDetails.getUsername());
    }

    @CrossOrigin
    @PostMapping()
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public void saveTodo(@Valid @RequestBody Todo todo){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        todo.setUsername(userDetails.getUsername());
        todoService.saveTodo(todo);
    }

    @CrossOrigin
    @GetMapping(path = "/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public Todo getTodo(@PathVariable("id")UUID id){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return todoService.getTodo(id);
    }



}
