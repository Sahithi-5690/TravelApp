package com.example.androidproject.Domain;

public class Category {
    private int imageResourceId;
    private String title;

    // Constructor, getters, and setters
    public Category(int imageResourceId, String title) {
        this.imageResourceId = imageResourceId;
        this.title = title;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}


