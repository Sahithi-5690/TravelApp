package com.example.androidproject.Domain;

import java.io.Serializable;

public class ItemDomain implements Serializable{
    private String title;
    private double price;
    private String address;
    private float score;
    private int pic;
    private int descriptionResId;

    // Constructor
    public ItemDomain(String title, double price, String address, float score, int pic, int descriptionResId) {
        this.title = title;
        this.price = price;
        this.address = address;
        this.score = score;
        this.pic = pic;
        this.descriptionResId = descriptionResId;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public int getDescriptionResId() { return descriptionResId;}

    public void setDescriptionResId(int descriptionResId) { this.descriptionResId = descriptionResId;}


}
