package com.example;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class ToDoItem {
    private String name;
    private List<String> comments;
    private Estado estado;

    private LocalDateTime startTime;
    private LocalDateTime finishTime;

    public ToDoItem(String name){
        this.name=name;
        this.comments=new ArrayList<>();
        this.estado=new Pending();
    }

    public void start(){
        estado.start(this);
    }

    public void togglePause(){
        estado.togglePause(this);
    }

    public void finish(){
        estado.finish(this);
    }

    public Duration workedTime(){
        
        if (startTime==null){
            throw new RuntimeException("El ToDoItem todavia no fue iniciado");
        }    
        
        if (finishTime!=null){
            return Duration.between(startTime,finishTime);
        }
        return Duration.between(startTime,LocalDateTime.now());
    }   

    public void addComment(String comment){
        if (!(estado instanceof Finished)){
            comments.add(comment);
        }
    }

    public void setStartTime(LocalDateTime time){
        this.startTime=time;
    }

    public void setFinishTime(LocalDateTime time){
        this.finishTime=time;
    }

    public void setEstado(Estado estado){
        this.estado=estado;
    }
}
