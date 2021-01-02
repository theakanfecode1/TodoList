package com.daniel.TodoList.services;

import com.daniel.TodoList.models.Todo;
import com.daniel.TodoList.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos(String username) {
        return todoRepository.findAllByUsername(username);
    }

    public Todo getTodo(UUID id) {
        return todoRepository.getOne(id);
    }

    public void saveTodo(Todo todo) {
        todoRepository.save(todo);
    }

}
