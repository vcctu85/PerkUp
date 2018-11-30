package com.example.macbook.perkupapp.Model;

import java.util.ArrayList;

public class Log {
    private String title, location, date;
    private Integer image;
    public Log() {
    }

    public Log(String name, Integer image, String location,
                 String date) {
        this.title = name;
        this.image = image;
        this.location = location;
        this.date = date;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getLocation() {
        return location;
    }

    public void setRating(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
