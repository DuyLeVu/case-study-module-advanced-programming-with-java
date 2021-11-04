package com.model;

public class Account {
    private int id;
    private String username;
    private String password;
    private Album  albums;

    public Account() {
    }

    public Account(int id, String username, String password, Album albums) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.albums = albums;
    }
}
