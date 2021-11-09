package com.model;

import com.service.GeneralService;

import java.util.List;

public class Client implements GeneralService<Album> {
    private int id;
    private String username;
    private String password;
    private String name;
    private List<Album> listAlbum;

    public Client() {
    }

    public Client(int id, String name, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Album> getListAlbum() {
        return listAlbum;
    }

    public void setListAlbum(List<Album> listAlbum) {
        this.listAlbum = listAlbum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", listAlbum=" + listAlbum +
                '}';
    }

    @Override
    public void create(Album album) {
        listAlbum.add(album);
    }

    @Override
    public void delete(String name) {
        int index = findIndexByName(name);
        if (index == -1) System.out.println("This album is not available");
        else listAlbum.remove(index);
    }

    @Override
    public void update(String name, String newName) {
        int index = findIndexByName(name);
        if (index == -1) System.out.println("This song is not available");
        else listAlbum.get(index).setName(newName);
    }

    @Override
    public void findByName(String name) {
        for (int i = 0; i < listAlbum.size(); i++) {
            if (listAlbum.get(i).getName().contains(name)) {
                System.out.println(listAlbum.get(i));
            }
        }
    }

    @Override
    public List displayAll() {
        return null;
    }

    @Override
    public void display() {
        for (Album album : listAlbum){
            System.out.println(album);
        }
    }

    @Override
    public int findIndexByName(String name) {
        int indexOf = -1;
        for (int i = 0; i < listAlbum.size(); i++) {
            if (listAlbum.get(i).getName().equals(name)) {
                indexOf = i;
                break;
            }
        }
        return indexOf;
    }
}