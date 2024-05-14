package com.Todo.Repository;

import com.Todo.Entity.Todo;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends MongoRepository<Todo, ObjectId>{
    Optional<Todo> findById(String id);
}