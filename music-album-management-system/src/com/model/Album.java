package com.model;

import java.util.List;

public class Album {
    private int id;
    private String name;
    private List<Song> listSong;


    public Album() {
    }

    public Album(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Album(int id, String name, List<Song> listSong) {
        this.id = id;
        this.name = name;
        this.listSong = listSong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getListSong() {
        return listSong;
    }

    public void setListSong(List<Song> listSong) {
        this.listSong = listSong;
    }

    @Override
    public String toString() {
        return ";" + getId() + ";" + getName() + ";";
    }
}
