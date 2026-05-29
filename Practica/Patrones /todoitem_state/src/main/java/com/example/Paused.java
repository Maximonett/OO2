package com.example;

import java.time.LocalDateTime;

public class Paused extends Estado{
    
    @Override 
    public void togglePause(ToDoItem item){
        item.setEstado(new InProgress());
    }
    @Override
    public void finish(ToDoItem item){
        item.setEstado(new Finished());
        item.setFinishTime(LocalDateTime.now());
    }
}
