package com.example;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String name;
    private String surname;
    private String screenName;
    private List<Tweet> tweeList;

    public Usuario(String name, String surname, String screenName, List<Tweet> tweeList) {
        this.name = name;
        this.surname = surname;
        this.screenName = screenName;
        this.tweeList = new ArrayList<>(); 
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getScreenName() {
        return screenName;
    }

    public List<Tweet> getTweeList() {
        return tweeList;
    }

    public void publicarTweet(Tweet nuevoTweet){
        this.tweeList.add(nuevoTweet);
    }

}
