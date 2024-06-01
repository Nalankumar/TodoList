package com.Todo.Entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Document(collection = "Todo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {

    
    @Id
    private ObjectId id;
    private boolean status;
    private boolean important;
    @DocumentReference
    private List<Todo> tasks;

    public boolean getStatus(){
        return this.status;
    }
}
