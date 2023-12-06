package com.vrx.todo.dao;

import com.vrx.todo.helper.TodoHelper;
import com.vrx.todo.model.Todo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDateTime;

public class TodoRowMapper implements RowMapper<Todo> {
    @Override
    public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
        Todo todo = new Todo();
        todo.setId((int) rs.getInt("id"));
        todo.setTitle((String) rs.getString("title"));
        todo.setContent((String) rs.getString("content"));
        todo.setStatus((String) rs.getString("status"));
        try {
            todo.setAddedDate(TodoHelper.parseDate((LocalDateTime) rs.getObject("addedDate")));
            todo.setTodoDate(TodoHelper.parseDate((LocalDateTime) rs.getObject("todoDate")));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return todo;
    }
}
