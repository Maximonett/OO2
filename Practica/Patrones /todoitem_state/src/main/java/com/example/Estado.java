package com.example;

public abstract class Estado {
    
    public void start(ToDoItem item){};

    public void togglePause(ToDoItem item){
        throw new RuntimeException("El objeto ToDoItem no se encuentra en pause o in-progress");
    }

    public void finish(ToDoItem item){};
}
