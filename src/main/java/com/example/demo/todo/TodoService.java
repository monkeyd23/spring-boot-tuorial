package com.example.demo.todo;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.IntStream;

@Service
public class TodoService {

    List<Todo> todos = new ArrayList<>(Arrays.asList(
            new Todo(1L, "Todo1", "Todo1 Description", new Date(), TodoStatus.PENDING),
            new Todo(2L, "Todo2", "Todo2 Description", new Date(), TodoStatus.PENDING)
    ));

    public List<Todo> getAll() {
        return todos;
    }

    public Todo getTodo(Long id) throws Exception {
        for (Todo todo : todos) {
            if (todo.getId().equals(id)) return todo;
        }
        throw new Exception("Invalid Id");
    }

    public void addTodo(Todo todo) {
        todos.add(todo);
    }

    public void updateTodo(Todo newTodo) throws Exception {
        int index = -1;
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getId().equals(newTodo.getId())) {
                index = i;
                break;
            }
        }
        if (index == -1) throw new Exception("Invalid Id");
        todos.set(index, newTodo);
    }

    public void deleteTodo(Long id) throws Exception {
        int index = -1;
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        if (index == -1) throw new Exception("Invalid Id");
        todos.remove(index);
    }
}
