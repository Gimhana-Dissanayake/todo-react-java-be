package com.example.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.domain.Todo;
import com.example.repository.TodoRepository;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    private static List<Todo> todos = new ArrayList<Todo>();

    static {
        todos.add(new Todo("1", "todoone", "description1", new Date(), false));
        todos.add(new Todo("2", "todotwo", "description2", new Date(), false));
        todos.add(new Todo("3", "todothree", "description3", new Date(), true));
        todos.add(new Todo("4", "todofour", "description4", new Date(), false));
        todos.add(new Todo("5", "todofive", "description5", new Date(), true));
    }

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public Todo save(Todo todo) {

        if (todo.getId().equals("-1")) {
            todo.setId(null);

            return todoRepository.save(todo);
        } else {
            return todoRepository.save(todo);
        }

    }

    public Todo deleteById(String id) {

        Optional<Todo> todo = todoRepository.findById(id);

        if (todo.isPresent()) {
            todoRepository.deleteById(id);
            return todo.get();
        } else {
            return null;
        }

    }

    public Optional<Todo> findById(String id) {

        return todoRepository.findById(id);

    }

}
