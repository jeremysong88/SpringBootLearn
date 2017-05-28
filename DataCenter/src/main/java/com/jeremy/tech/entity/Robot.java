package com.jeremy.tech.entity;

/**
 * Created by jeremysong on 5/21/2017.
 */
public class Robot {

    private String type;
    private String id;

    public Robot(String type, String id) {
        this.type = type;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void run() {
        System.out.println(type + "" + id + " is running!");
    }

    public void speak(String words) {
        System.out.println(type + " " + id + " says " + words);
    }

}