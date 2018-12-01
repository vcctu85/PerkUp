package com.example.macbook.perkupapp.Model;

import java.util.ArrayList;

public class Log {
    private String title, location, date, personalLabel;
    private Integer image;
    public Log() {
    }

    public Log(String name, Integer image, String location,
                 String date, String personalLabel) {
        this.title = name;
        this.image = image;
        this.location = location;
        this.date = date;
        this.personalLabel = personalLabel;

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

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPersonalLabel() {
        return personalLabel;
    }

    public void setPersonalLabel(String personalLabel) {
        this.personalLabel = personalLabel;
    }
}
