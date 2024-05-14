package com.Todo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Todo.Repository.TodoRepository;
import java.util.List;
import java.util.Optional;

import com.Todo.Entity.Todo;

@Service
public class TodoService {
    @Autowired
    TodoRepository todoRepository;
    public List<Todo> getAllTasks(){
        return  todoRepository.findAll();
    }

    public Optional<Todo> findById(String id){
        return todoRepository.findById(id);
    }
}
