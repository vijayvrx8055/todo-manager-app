package com.vrx.todo.dao;

import com.vrx.todo.model.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TodoJdbcDaoImpl implements TodoJdbcDao {

    Logger logger = LoggerFactory.getLogger(TodoJdbcDaoImpl.class);

//    @Autowired
    private JdbcTemplate template;


    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate( JdbcTemplate template) {
        this.template = template;
    }

    public TodoJdbcDaoImpl(@Autowired JdbcTemplate template) {
        this.template = template;
//        String CREATE_TABLE = "Create table IF_NOT_EXISTS todos(id int primary key, title varchar(100) not null, content varchar(450),status varchar(10) not null, addedDate datetime, todoDate datetime)";
//        template.update(CREATE_TABLE);
        logger.info("TODO table created");
    }

    private static final String SAVE_TODO_QUERY = "Insert into todos(id,title,content,status,addedDate,todoDate) values(?,?,?,?,?,?);";
    private static final String GET_TODO_QUERY = "Select * from todos where id=?;";
    private static final String GET_ALL_TODOS_QUERY = "Select * from todos;";
    private static final String UPDATE_TODO_QUERY = "Update Todos Set title=?,content=?,status=?,addedDate=?,todoDate=? where id=?;";
    private static final String DELETE_TODO = "Delete from todos where id=?;";

    @Override
    public Todo saveTodo(Todo todo) {
        logger.info("Todo: {}",todo);
        int rows = template.update(SAVE_TODO_QUERY,
                todo.getId(), todo.getTitle(),
                todo.getContent(), todo.getStatus(),
                todo.getAddedDate(), todo.getTodoDate());
        logger.info("Todo Created.");
        logger.info("Todo added rows: {}", rows);
        return todo;
    }

    @Override
    public Todo getTodo(int id) {
        Todo todo = template.queryForObject(GET_TODO_QUERY, Todo.class, id);
        logger.info("getTodo(): {}", todo);
        return todo;
    }

    @Override
    public List<Todo> getAllTodos() {
        List<Map<String, Object>> todos = null;
//        todos = template.queryForStream(GET_ALL_TODOS_QUERY,todos);
        logger.info("getAllTodos(): {}", todos);
        return null;
    }

    @Override
    public Todo updateTodo(Todo todo) {
        int rows = template.update(UPDATE_TODO_QUERY,todo.getTitle(),todo.getContent(),todo.getStatus(),todo.getAddedDate(),todo.getTodoDate());
        if(rows > 0){
            logger.info("Todo updated successfully..");
        }
        return todo;
    }

    @Override
    public String deleteTodo(int id) {
        int rows = template.update(DELETE_TODO,Todo.class,id);
        return (rows > 0 )?"Todo Deleted Successfully....":"ERROR in Deleting";
    }
}
