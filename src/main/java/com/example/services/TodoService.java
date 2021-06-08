package com.example.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.domain.Todo;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<Todo>();

    static {
        todos.add(new Todo("1", "todoone", "description1", new Date(), false));
        todos.add(new Todo("2", "todotwo", "description2", new Date(), false));
        todos.add(new Todo("3", "todothree", "description3", new Date(), true));
        todos.add(new Todo("4", "todofour", "description4", new Date(), false));
        todos.add(new Todo("5", "todofive", "description5", new Date(), true));
    }

    public List<Todo> findAll() {
        return todos;
    }

    public Todo deleteById(String id) {
        Optional<Todo> todo = findById(id);

        if (!todo.isPresent()) {
            System.out.println(todo);
            return null;
        }

        if (todos.remove(todo.get())) {

            return todo.get();
        }

        return null;

    }

    public Optional<Todo> findById(String id) {

        return todos.stream().filter((td) -> (td.getId().equals(id))).findFirst();

    }

}
