package com.vrx.todo.service;

import com.vrx.todo.dao.TodoJdbcDao;
import com.vrx.todo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoJdbcDao jdbcDao;

    @Override
    public Todo createTodo(Todo todo) {
        todo.setAddedDate(new Date());
        return jdbcDao.saveTodo(todo);
    }

    @Override
    public Todo getTodo(int id) {
        return jdbcDao.getTodo(id);
    }

    @Override
    public List<Todo> getAllTodos() {
        return jdbcDao.getAllTodos();
    }

    @Override
    public Todo updateTodo(Todo todo) {
        return jdbcDao.updateTodo(todo);
    }

    @Override
    public String deleteTodo(int id) {
        return jdbcDao.deleteTodo(id);
    }
}
