package com.model;

import com.service.GeneralService;

import java.util.ArrayList;
import java.util.List;

public class Client implements GeneralService<Album> {
    private int id;
    private String username;
    private String password;
    private String name;
    private List<Album> listAlbum = new ArrayList<>();
    private static Client instance;

    public Client() {
    }

    public Client(int id, String name,String username, String password)
    {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public Client(int id, String name, String username, String password, List<Album> listAlbum) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.listAlbum = listAlbum;
    }

    public static Client getInstance() {
        if (instance == null) instance = new Client();
        return instance;
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
        else Client.getInstance().listAlbum.remove(index);
    }

    @Override
    public void update(String name, String newName) {
        int index = findIndexByName(name);
       this.listAlbum.get(index).setName(newName);
    }

    @Override
    public void findRelativeByName(String name) {
        for (int i = 0; i < listAlbum.size(); i++) {
            if (Client.getInstance().listAlbum.get(i).getName().contains(name)) {
                System.out.println(Client.getInstance().listAlbum.get(i));
            }
        }
    }

    @Override
    public Album findByName(String name) {
        int index = -1;
        for (int i = 0; i < listAlbum.size(); i++) {
            if (this.listAlbum.get(i).getName().equals(name)) {
                index = i;
            }
        }
        if (index == -1) {
            return null;
        } else {
            return this.listAlbum.get(index);
        }
    }

    @Override
    public List displayAll() {
        return null;
    }

    @Override
    public void display() {
        System.out.printf("|%-12s|%-12s","Album Id","Album Name");
        System.out.println();
        for (Album album : this.listAlbum) {
            System.out.println(album);
        }
    }

    public int findIndexByName(String name) {
        int indexOf = -1;
        for (int i = 0; i < listAlbum.size(); i++) {
            if (this.listAlbum.get(i).getName().equals(name)) {
                indexOf = i;
                break;
            }
        }
        return indexOf;
    }

    public Album findById(int id) {
        int index = -1;
        for (int i = 0; i < this.listAlbum.size(); i++) {
            if (this.listAlbum.get(i).getId() == id) {
                index = i;
            }
        }
        if (index == -1) {
            return null;
        } else {
            return this.listAlbum.get(index);
        }
    }
}
