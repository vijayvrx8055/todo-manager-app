package com.vrx.todo.service;

import com.vrx.todo.model.Todo;
import com.vrx.todo.repository.TodoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Primary
public class TodoJpaServiceImpl implements TodoService {

    Logger logger = LoggerFactory.getLogger(TodoJpaServiceImpl.class);

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public Todo createTodo(Todo todo) {
        todo.setId(new Random().nextInt(9999));
        todo.setAddedDate(new Date());
        Optional<Todo> save = Optional.of(todoRepository.save(todo));
        logger.info("Todo Created Successfully: {}", save);
        return save.orElseThrow(() -> new RuntimeException("Unable to save Todo..."));
    }

    @Override
    public Todo getTodo(int id) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        logger.info("Todo found for id: {}", id);
        return optionalTodo.orElseThrow(() -> new RuntimeException("Todo not found for id:" + id));
    }

    @Override
    public List<Todo> getAllTodos() {
        Optional<List<Todo>> todoList = Optional.of(todoRepository.findAll());
        logger.info("All Todos fetched from DB.");
        return todoList.orElseThrow(() -> new RuntimeException("Error in fetching Todos..."));
    }

    @Override
    public Todo updateTodo(Todo todo, int id) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        Todo todo1 = optionalTodo.orElseThrow(() -> new RuntimeException("TODO not found for ID."));
        todo1.setTitle(todo.getTitle());
        todo1.setStatus(todo.getStatus());
        todo1.setTodoDate(todo.getTodoDate());
        todo1.setAddedDate(todo.getAddedDate());
        todo1.setContent(todo.getContent());
        logger.info("Todo updated: {}", todo1);
        return todoRepository.save(todo1);
    }

    @Override
    public String deleteTodo(int id) {
        todoRepository.deleteById(id);
        return "User Deleted Successfully!";
    }

    @Override
    public String deleteMultipleTodos(Integer[] todoIds) {
        todoRepository.deleteAllById(List.of(todoIds));
        return "Todos Deleted!!!";
    }
}
