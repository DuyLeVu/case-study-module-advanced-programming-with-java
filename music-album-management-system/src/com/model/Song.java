package com.model;

public class Song {
    private int id;
    private String name;

    public Song() {
    }

    public Song(String name) {
        this.name = name;
    }

    public Song(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
