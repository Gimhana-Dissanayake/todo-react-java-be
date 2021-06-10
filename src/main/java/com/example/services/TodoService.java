package com.example.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public Todo save(Todo todo) {

        if (todo.getId().equals("-1")) {

            int tId = todos.stream().map((t) -> {
                return Integer.parseInt(t.getId());
            }).max((i1, i2) -> i1.compareTo(i2)).get() + 1;

            todo.setId(tId + "");
            todos.add(todo);

        } else {

            deleteById(todo.getId());

            todos.add(todo);
        }
        return todo;
    }

    public Todo deleteById(String id) {
        Optional<Todo> todo = findById(id);

        if (!todo.isPresent()) {

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
