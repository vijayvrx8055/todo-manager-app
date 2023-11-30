package com.vrx.todo.service;

import com.vrx.todo.dao.TodoJdbcDao;
import com.vrx.todo.model.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoJdbcDao jdbcDao;

    Logger logger = LoggerFactory.getLogger(TodoServiceImpl.class);

    @Override
    public Todo createTodo(Todo todo) {
        todo.setId(new Random().nextInt(9999));
        todo.setAddedDate(new Date());
        return jdbcDao.saveTodo(todo);

    }

    @Override
    public Todo getTodo(int id) {
        try {
            return jdbcDao.getTodo(id);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Todo> getAllTodos() {
        return jdbcDao.getAllTodos();
    }

    @Override
    public Todo updateTodo(Todo todo, int id) {
        return jdbcDao.updateTodo(todo, id);
    }

    @Override
    public String deleteTodo(int id) {
        return jdbcDao.deleteTodo(id);
    }

    @Override
    public String deleteMultipleTodos(Integer[] todoIds) {
        return jdbcDao.deleteMultipleTodos(todoIds);
    }
}
