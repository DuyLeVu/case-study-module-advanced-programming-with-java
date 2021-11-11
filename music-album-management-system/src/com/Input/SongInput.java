package com.Input;

import com.model.Song;
import com.model.Validation;
import com.service.Impl.SongService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SongInput {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static Song inputSong() {
        System.out.println("Enter Song information");
        int songId = inputSongId();
        SCANNER.nextLine();
        System.out.print("Enter Song name: ");
        String songName = inputSongName();
        return new Song(songId, songName);
    }

    private static int inputSongId() {
        boolean existId;
        int songId = 0;
        try {
            do {
                System.out.print("Enter Song Id: ");
                songId = SCANNER.nextInt();
                existId = SongService.getInstance().findById(songId) != null;
                if (existId) System.out.println("Id already existed!");
            } while (existId);
        } catch (InputMismatchException e) {
            System.out.println("Input mismatch exception");
        }
        return songId;
    }

    public static String inputSongName() {
        String songName;
        boolean invalidSongName;
        do {
            System.out.print("Enter new Song name: ");
            songName = SCANNER.nextLine();
            invalidSongName = !Validation.isValid(songName, Validation.NAME_REGEX);
            if (invalidSongName) System.out.println("Wrong format of Song name! ");
        } while (invalidSongName);
        return songName;
    }

    public static int inputSongIdToFind() {
        System.out.print("Enter Song Id: ");
        return SCANNER.nextInt();
    }
}
