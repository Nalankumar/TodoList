package com.Todo.Controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @GetMapping("/all")
    public List<Todo> getAllTasks(){
        return todoService.getAllTasks();
    }

    @GetMapping("/get/{id}")
    public Optional<Todo> findByTodoId(@PathVariable String id){
        return todoService.findById(id);
    }

    @PostMapping("/addTodo")
    public ResponseEntity<Todo> insertTodo(@RequestBody Todo todo){
        return new ResponseEntity<>(todoService.insertTodo(todo), HttpStatus.CREATED);
    }

    @PutMapping("/markAsCompleted/{id}")
    public ResponseEntity<Todo> markAsCompleted(@PathVariable("id") String id,@RequestBody Todo todo){
        return new ResponseEntity<>(todoService.markAsCompleted(id ,todo), HttpStatus.NO_CONTENT);
    }

    @PutMapping("/markAsFavorite/{id}")
    public ResponseEntity<Todo> markAsFavorite(@PathVariable("id") String id,@RequestBody Todo todo){
        return new ResponseEntity<>(todoService.markAsFavorite(id ,todo), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/removebyId/{todoId}")
    public ResponseEntity<Optional<Todo>> removebyId(@PathVariable ObjectId todoId){
        return new ResponseEntity<>(todoService.removebyId(todoId), HttpStatus.NO_CONTENT);
    }
}
