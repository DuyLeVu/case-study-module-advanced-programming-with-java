package com;

import com.Input.SongInput;
import com.controller.AdminApp;
import com.controller.App;
import com.model.Song;
import com.service.Impl.ClientService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static final Scanner SCANNER = new Scanner(System.in);
    private static ClientService clientService;
    public static final int INDEX_ADMIN = 0;

    public static void main(String[] args) {
        App app = new App();
        AdminApp adminApp = new AdminApp();
        int choice_1;
        boolean check_1 = false;
        try {
            do {
                menu_app();
                System.out.print("Enter your choice 1: ");
                choice_1 = SCANNER.nextInt();
                SCANNER.nextLine();
                switch (choice_1) {
                    case 1:
                        if (app.login() == 1) {
                            int choice_2;
                            do {
                                menu_client();
                                System.out.print("Enter your choice 2: ");
                                choice_2 = SCANNER.nextInt();
                                SCANNER.nextLine();
                                switch (choice_2) {
                                    case 1: {
                                        app.createNewAlbum();
                                        break;
                                    }
                                    case 2: {
                                        app.displayAllAlbum();
                                        break;
                                    }
                                    case 3: {
                                        app.updateAlbum();
                                        break;
                                    }
                                    case 4: {
                                        app.deleteAlbum();
                                        break;
                                    }
                                    case 5: {
                                        app.findAlbumByName();
                                    }
                                    case 6: {
                                        System.exit(6);
                                    }
                                }
                            } while (choice_2 <= 6 && choice_2 >= 1);
                        } else {
                            System.out.println("Admin App");
                            adminFunction(adminApp);
                        }
                        break;
                    case 2:
                        app.register();
                        break;
                    case 3:
                        System.exit(3);
                        break;
                }
            } while (!check_1);
        } catch (InputMismatchException e) {
            System.out.println("Input mismatch exception");
        }
    }

    public static void menu_app() {
        System.out.println("-----------------------------MENU_APP--------------------------------");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");

    }

    public static void menu_client() {
        System.out.println("-----------------------------MENU_CLIENT--------------------------------");
        System.out.println("1. Creat new album");
        System.out.println("2. Display album list");
        System.out.println("3. Update album");
        System.out.println("4. Delete album by name");
        System.out.println("5. Find album by name");
        System.out.println("6. Exit");
    }

    public static void adminFunction(AdminApp adminApp) {
        int adminChoice;
        try {
            do {
                menu_admin();
                System.out.print("Admin_Enter your choice: ");
                adminChoice = SCANNER.nextInt();
                SCANNER.nextLine();
                switch (adminChoice) {
                    case 1:
                        adminApp.createSong();
                        break;
                    case 2:
                        adminApp.displaySong();
                        break;
                    case 3:
                        int songIdUpdate = SongInput.inputSongIdToFind();
                        Song songUpdate = SongInput.inputSong();
                        adminApp.update(songIdUpdate, songUpdate);
                        break;
                    case 4:
                        int songIDDelete = SongInput.inputSongIdToFind();
                        adminApp.deleteSong(songIDDelete);
                        break;
                    case 5:
                        int songIdToFind = SongInput.inputSongIdToFind();
                        Song songFind = adminApp.findById(songIdToFind);
                        if (songFind == null) System.out.println("Found no taxi with id " + songIdToFind);
                        else System.out.println(songFind);
                        break;
                    case 6:
                        adminApp.sortSong();
                        System.out.println("Sorted successfully!");
                        break;
                    case 7:
                        adminApp.displayClient();
                        break;
                    case 9:
                        System.exit(9);
                        break;
                }
            } while (adminChoice <= 9 && adminChoice >= 1);
        }catch (InputMismatchException e){
            System.out.println("Input mismatch exception");
        }
    }

    public static void menu_admin() {
        System.out.println("-----------------------------MENU_ADMIN---------------------------------");
        System.out.println("1. Add new song");
        System.out.println("2. Display list song");
        System.out.println("3. Update song");
        System.out.println("4. Delete song by name");
        System.out.println("5. Find song by name");
        System.out.println("6. Sort song");
        System.out.println("7. Display all Client");
//        System.out.println("8. Filter order by date");
        System.out.println("9. Exit");

    }

}
