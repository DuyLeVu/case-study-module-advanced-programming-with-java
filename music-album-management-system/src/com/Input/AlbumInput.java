package com.Input;

import com.model.Album;
import com.model.Client;
import com.model.Validation;
import com.service.Impl.ClientService;

import java.util.Scanner;

public class AlbumInput {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static Album inputAlbum(int indexOfAcc) {
        System.out.println("Enter Album information");
        String albumName = inputAlbumName(indexOfAcc);
        int albumId = inputAlbumId();
        SCANNER.nextLine();
        return new Album(albumId, albumName);
    }

    private static int inputAlbumId() {
        boolean existId;
        int albumId;
        do {
            System.out.print("Enter Album's Id: ");
            albumId = SCANNER.nextInt();
            existId = Client.getInstance().findById(albumId) != null;
            if (existId) System.out.println("Id already existed!");
        } while (existId);
        return albumId;
    }

    public static String inputAlbumName(int indexOfAcc) {
        String albumName;
        boolean existAlbumName;
        boolean invalidAlbumName;
        do {
            System.out.print("Enter new album's name: ");
            albumName = SCANNER.nextLine();
            existAlbumName = ClientService.getInstance().getListClient().get(indexOfAcc).findByName(albumName) != null;
            invalidAlbumName = !Validation.isValid(albumName, Validation.NAME_REGEX);
            if (invalidAlbumName) System.out.println("Wrong format of Album's name! ");
            else if (existAlbumName) System.out.println("Album's name already existed! ");
        } while (invalidAlbumName || existAlbumName);
        return albumName;
    }
}
