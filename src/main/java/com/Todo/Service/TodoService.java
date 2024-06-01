package com.Todo.Service;

import org.bson.types.ObjectId;
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
        return todoRepository.findAll();
    }

    public Optional<Todo> findById(String id){
        return todoRepository.findById(id);
    }

    @SuppressWarnings("null")
    public Todo insertTodo(Todo todo){
        return todoRepository.insert(todo);
    }

    @SuppressWarnings("null")
    public Todo markAsCompleted(String id, Todo todo){
        Todo t = null;
        Optional<Todo> todoOptional = todoRepository.findById(id);
        if(todoOptional.isPresent()){
            t = todoOptional.get();
            boolean bval = t.getStatus();
            if(bval){
                t.setStatus(false);
            }else{
                t.setStatus(true);
            }
            
        }
        return todoRepository.save(t);
    }

    @SuppressWarnings("null")
    public Optional<Todo> removebyId(ObjectId todoId){    
        todoRepository.deleteById(todoId);
        return null;
    }
}
