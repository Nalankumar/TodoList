package com.Todo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Todo.Service.TodoService;
import java.util.List;
import java.util.Optional;
import com.Todo.Entity.Todo;
@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    TodoService todoService;

    public List<Todo> getAllTasks(){
        return todoService.getAllTasks();
    }

    public Optional<Todo> findByTodoId(String id){
        return todoService.findById(id);
    }
}
