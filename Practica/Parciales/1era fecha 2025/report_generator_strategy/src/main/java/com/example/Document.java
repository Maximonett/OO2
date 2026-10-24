package com.example;

import java.util.ArrayList;
import java.util.List;

public class Document {

    private String title;
    private String subtitle;
    private List<String> authors;

    public Document(String title) {
        this.title = title;
        this.authors = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void addAuthor(String author) {
        this.authors.add(author);
    }
}
