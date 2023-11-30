package com.vrx.todo.dao;

import com.vrx.todo.model.Todo;

import java.text.ParseException;
import java.util.List;

public interface TodoJdbcDao {

    //save todo in database
    public Todo saveTodo(Todo todo);

    //get single todo from database
    public Todo getTodo(int id) throws ParseException;

    //get all todo from database
    public List<Todo> getAllTodos();

    //update todo in database
    public Todo updateTodo(Todo todo, int id);

    //delete todo from database
    public String deleteTodo(int id);
}
