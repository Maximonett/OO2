package com.example;

import java.time.LocalDateTime;

public class InProgress extends Estado {
    @Override 
    public void togglePause(ToDoItem item){
        item.setEstado(new Paused());
    }

    @Override
    public void finish(ToDoItem item){
        item.setEstado(new Finished());
        item.setFinishTime(LocalDateTime.now());
    }
}
