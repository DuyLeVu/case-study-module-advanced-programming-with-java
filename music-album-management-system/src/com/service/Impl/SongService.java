package com.service.Impl;

import com.model.Song;
import com.service.GeneralService;

import java.util.List;

public class SongService implements GeneralService<Song> {
    private List<Song> listSong;
    private  static SongService instance;
//    public static final  String PATH_FILE_CLIENT = "E:\\Personal\\C0821I1_LeVuDuy\\Module Advanced Programming with Java\\case-study-module-advanced-programming-with-java\\music-album-management-system\\src\\com\\file\\DataClient.csv";

//    public SongService() {
//        this.listClient = ClientIO.readFromFile(PATH_FILE_CLIENT);
//    }

    public static SongService getInstance() {
        if (instance == null) instance = new SongService();
        return instance;
    }

    public SongService() {
    }

    public SongService(List<Song> listSong) {
        this.listSong = listSong;
        listSong.add(new Song(1, "A LONG FINAL"));
        listSong.add(new Song(2, "HÃY TRAO CHO HUY"));
    }


    public void create(Song song) {
        listSong.add(song);
    }

    public void delete(String name) {
        int index = findIndexByName(name);
        if (index == -1) System.out.println("This song is not available");
        else listSong.remove(index);
    }

    public void update(String name, String newName) {
        int index = findIndexByName(name);
        if (index == -1) System.out.println("This song is not available");
        else listSong.get(index).setName(newName);
    }

    public void findRelativeByName(String name) {
        for (int i = 0; i < listSong.size(); i++) {
            if (listSong.get(i).getName().contains(name)) {
                System.out.println(listSong.get(i));
            }
        }
    }

    @Override
    public Song findByName(String name) {
        int index = -1;
        for (int i = 0; i < listSong.size(); i++) {
            if (listSong.get(i).getName().equals(name)) {
                index = i;
            }
        }
        if (index == -1) {
            return null;
        } else {
            return listSong.get(index);
        }
    }

    public int findIndexByName(String name) {
        int indexOf = -1;
        for (int i = 0; i < listSong.size(); i++) {
            if (listSong.get(i).getName().equals(name)) {
                indexOf = i;
                break;
            }
        }
        return indexOf;
    }

    public List<Song> displayAll() {
        return null;
    }

    public static void display() {
        for (Song song : listSong) {
            System.out.println(song);
        }
    }

    public Song findById(int id) {
        int index = -1;
        for (int i = 0; i < listSong.size(); i++) {
            if (listSong.get(i).getId() == id) {
                index = i;
            }
        }
        if (index == -1) {
            return null;
        } else {
            return listSong.get(index);
        }
    }
}
