package com.vrx.todo.controller;

import com.vrx.todo.model.Todo;
import com.vrx.todo.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    Logger logger = LoggerFactory.getLogger(TodoController.class);

    @Autowired
    private TodoService todoService;

    //create Todos
    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        Todo savedTodo = todoService.createTodo(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTodo);
    }

    //get Todo for any ID
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable("id") int id) {
        Todo todo = todoService.getTodo(id);
        return ResponseEntity.status(HttpStatus.OK).body(todo);
    }

    //get all Todos
    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos() {
        List<Todo> todos = todoService.getAllTodos();
        return ResponseEntity.status(HttpStatus.OK).body(todos);
    }

    //update Todo
    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@RequestBody Todo todoWithNewDetails, @PathVariable("id") int id) {
        Todo updatedTodo = todoService.updateTodo(todoWithNewDetails, id);
        return ResponseEntity.status(HttpStatus.OK).body(updatedTodo);
    }

    //delete Todo
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") int id) {
        String status = todoService.deleteTodo(id);
        return ResponseEntity.status(HttpStatus.OK).body(status);
    }
}
