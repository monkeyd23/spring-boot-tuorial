package com.example.demo.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class Controller {

    private final TodoService todoService;

    public Controller(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping()
    public List<Todo> getAll() {
        return todoService.getAll();
    }

    @GetMapping("/{id}")
    public Todo getTodo(@PathVariable Long id) throws Exception {
        return todoService.getTodo(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus addTodo(@RequestBody Todo todo) {
        todoService.addTodo(todo);
        return HttpStatus.CREATED;
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus updateTodo(@RequestBody Todo todo) throws Exception {
        todoService.updateTodo(todo);
        return HttpStatus.ACCEPTED;
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteTodo(@PathVariable Long id) throws Exception {
        todoService.deleteTodo(id);
        return HttpStatus.OK;
    }

}
