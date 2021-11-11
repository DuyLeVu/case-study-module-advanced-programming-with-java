package com.service.Impl;

import com.file.SongIO;
import com.model.Song;
import com.service.GeneralService;

import java.util.List;

import static com.file.Path.PATH_FILE_SONG;

public class SongService implements GeneralService<Song> {
    private List<Song> listSong;
    private static SongService instance;

    public SongService() {
       this.listSong = SongIO.readFromFile(PATH_FILE_SONG);
    }

    public static SongService getInstance() {
        if (instance == null) instance = new SongService();
        return instance;
    }


    public List<Song> getListSong() {
        return listSong;
    }

    public void setListSong(List<Song> listSong) {
        this.listSong = listSong;
    }

    public static void setInstance(SongService instance) {
        SongService.instance = instance;
    }

    public void create(Song song) {
        this.listSong.add(song);
        SongIO.writeToFile(PATH_FILE_SONG, this.listSong);
    }

    @Override
    public void delete(String name) {
        listSong.remove(findByName(name));
        System.out.println("Delete successfully!");
        SongIO.writeToFile(PATH_FILE_SONG, this.listSong);
    }

    @Override
    public void update(String name, String newName) {

    }

    public void update(int id, Song song) {
        int index = findIndexById(id);
        if (index == -1) System.out.println("This song is not available");
        else {
            this.listSong.set(index, song);
            System.out.println("Update successfully");
            SongIO.writeToFile(PATH_FILE_SONG, this.listSong);
        }
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

    public int findIndexById(int id) {
        int indexOf = -1;
        for (int i = 0; i < listSong.size(); i++) {
            if (listSong.get(i).getId() == id) {
                indexOf = i;
                break;
            }
        }
        return indexOf;
    }

    public List<Song> displayAll() {
        return null;
    }

    public void display() {
        for (Song song : listSong) {
            System.out.println(song);
        }
    }

    public Song findById(int id) {
        int index = -1;
        for (int i = 0; i < this.listSong.size(); i++) {
            if (this.listSong.get(i).getId() == id) {
                index = i;
            }
        }
        if (index == -1) {
            return null;
        } else {
            return listSong.get(index);
        }
    }

    public List<Song> findAll() {
        return this.listSong;
    }
}
