package com.controller;

import com.Input.SongInput;
import com.model.Song;
import com.service.Impl.ClientService;
import com.service.Impl.SongService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AdminApp {
    public static Scanner SCANNER = new Scanner(System.in);
    private ClientService clientService;
    private SongService songService;

    public AdminApp() {
        clientService = ClientService.getInstance();
        songService = SongService.getInstance();
    }

    public void createSong() {
        Song song = SongInput.inputSong();
        songService.create(song);
    }
//        if (songService.getListSong().size() == 0) {
//            System.out.println("Enter Song information");
//            String songName;
//            boolean invalidSongName;
//            do {
//                System.out.print("Enter new Song name: ");
//                songName = SCANNER.nextLine();
//                invalidSongName = !Validation.isValid(songName, Validation.NAME_REGEX);
//                if (invalidSongName) System.out.println("Wrong format of Song name! ");
//            } while (invalidSongName);
//            System.out.print("Enter Song Id: ");
//            int songId = SCANNER.nextInt();
//            SCANNER.nextLine();
//            Song song = new Song(songId, songName);
//            songService.getListSong().add(song);
//            SongIO.writeToFile(PATH_FILE_SONG, songService.getListSong());
//        } else {
//            Song song = SongInput.inputSong();
//            songService.getListSong().add(song);
//            SongIO.writeToFile(PATH_FILE_SONG, songService.getListSong());
//        }
//    }

    public void deleteSong(int id) {
        if (songService.findIndexById(id) == -1) System.out.println("This song is not available");
        else songService.delete(songService.getListSong().get(id).getName());
    }

    public void update(int id, Song song) {
        songService.update(id, song);
    }

    public Song findById(int id) {
        return songService.findById(id);
    }

    public List<Song> findAllSong() {
        return songService.findAll();
    }

    public void displaySong() {
        songService.display();
    }

    public void sortSong() {

        System.out.println("Sorting by Name...");

        Collections.sort(findAllSong(), new Comparator<Song>() {
            @Override
            public int compare(Song o1, Song o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        displaySong();
    }

    public void displayClient() {
        clientService.display();
    }


}
