package com.project.todolist_back.service;

import com.project.todolist_back.entity.Todo;
import com.project.todolist_back.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    // Injeção do repositório
    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    // Métodos CRUD

    // CREATE
    public Todo createTodo(Todo todo) {
        return repository.save(todo);
    }

    // READ
    public List<Todo> getTodo() {
        return repository.findAll();
    }

    // UPDATE
    public Todo updateTodo(Long id, Todo todo) {
        return repository.findById(id).map(existingTodo -> {
            existingTodo.setNome(todo.getNome());
            existingTodo.setDescricao(todo.getDescricao());
            existingTodo.setRealizado(todo.isRealizado());
            existingTodo.setPrioridade(todo.getPrioridade());
            return repository.save(existingTodo);
        }).orElse(null);
    }

    public void deleteTodo(Long id) {
        repository.deleteById(id);
    }
}
