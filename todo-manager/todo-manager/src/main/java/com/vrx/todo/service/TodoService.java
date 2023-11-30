package com.vrx.todo.service;

import com.vrx.todo.model.Todo;

import java.util.List;

public interface TodoService {
    Todo createTodo(Todo todo);

    Todo getTodo(int id);

    List<Todo> getAllTodos();

    Todo updateTodo(Todo todo, int id);

    String deleteTodo(int id);

    String deleteMultipleTodos(Integer[] todoIds);
}
