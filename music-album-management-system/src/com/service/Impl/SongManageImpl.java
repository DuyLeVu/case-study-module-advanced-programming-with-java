package com.service.Impl;

import com.model.Song;
import com.service.GeneralService;

import java.util.List;

public class SongManageImpl implements GeneralService<Song> {
    private List<Song> listSong;

    public SongManageImpl() {
    }

    public SongManageImpl(List<Song> listSong) {
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

    public void display() {
        for (Song song : listSong) {
            System.out.println(song);
        }
    }

}
