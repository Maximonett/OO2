package com.example;

import java.time.LocalDateTime;

public class Pending extends Estado {
    
    @Override 
    public void start(ToDoItem item){
        item.setEstado(new InProgress());
        item.setStartTime(LocalDateTime.now());
    }
}
