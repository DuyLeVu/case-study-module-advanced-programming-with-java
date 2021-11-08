package com.controller;

import com.model.Song;
import com.service.Impl.SongManageImpl;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Song> listSong = new ArrayList<>();
        SongManageImpl songManage = new SongManageImpl(listSong);
        songManage.display();
    }
}
