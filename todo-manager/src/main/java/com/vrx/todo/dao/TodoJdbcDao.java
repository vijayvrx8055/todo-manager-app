package com.vrx.todo.dao;

import com.vrx.todo.model.Todo;

import java.util.List;

public interface TodoJdbcDao {

    //save todo in database
    public Todo saveTodo(Todo todo);

    //get single todo from database
    public Todo getTodo(int id);

    //get all todo from database
    public List<Todo> getAllTodos();

    //update todo in database
    public Todo updateTodo(Todo todo);

    //delete todo from database
    public String deleteTodo(int id);
}
