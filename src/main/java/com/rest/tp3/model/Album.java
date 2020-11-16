package com.rest.tp3.model;

import java.util.List;

public class Album {

    private int id;
    private String title;
    private String editor;
    private List<String> authors;
    private float price;
    private int nbEx;

    public Album(int id, String title, String editor,
                 List<String> authors, float price, int nbEx) {
        this.id = id;
        this.title = title;
        this.editor = editor;
        this.authors = authors;
        this.price = price;
        this.nbEx = nbEx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNbEx() {
        return nbEx;
    }

    public void setNbEx(int nbEx) {
        this.nbEx = nbEx;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
