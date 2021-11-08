package com.model;

import com.service.GeneralService;

import java.util.List;

public class Account implements GeneralService {
    private int id;
    private String username;
    private String password;
    private List<Album> listAlbum;

    @Override
    public void create(Object o) {

    }

    @Override
    public void delete(String name) {

    }

    @Override
    public void update(String name, String newName) {

    }

    @Override
    public void findByName(String name) {

    }

    @Override
    public List displayAll() {
        return null;
    }

    @Override
    public void display() {

    }

    @Override
    public int findIndexByName(String name) {
        return 0;
    }
}
