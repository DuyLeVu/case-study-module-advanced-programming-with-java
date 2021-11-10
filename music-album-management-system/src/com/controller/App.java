package com.controller;

import com.Input.AlbumInput;
import com.Input.ClientInput;
import com.file.ClientIO;
import com.model.Album;
import com.model.Client;
import com.model.Validation;
import com.service.Impl.ClientService;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.file.Path.PATH_FILE_CLIENT;

public class App {
    public static Scanner SCANNER = new Scanner(System.in);
    public static final int ROLE_ADMIN = 2;
    public static final int ROLE_CLIENT = 1;
    private ClientService clientService;
    private Client client;

    public App() {
        clientService = ClientService.getInstance();
    }

    public ClientService getClientService() {
        return clientService;
    }

    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    public int login() {
        String username = null;
        Client clientLogin = null;
        int role = 0;
        try {
            do {
                System.out.print("Enter username: ");
                username = SCANNER.nextLine();
                clientLogin = clientService.findByName(username);
                if (clientLogin == null) {
                    System.out.println("Wrong username!");
                    System.out.println("1. Continue");
                    System.out.println("0. Exit");
                    int choice = SCANNER.nextInt();
                    switch (choice) {
                        case (1) -> SCANNER.nextLine();
                        case (0) -> System.exit(0);
                    }
                }
            } while (clientLogin == null);
        } catch (InputMismatchException e) {
            System.out.println("Input mismatch exception");
        }

        String password;
        do {
            System.out.print("Enter password: ");
            password = SCANNER.nextLine();
            boolean isAdminAcount = username.equals("ProAdmin") && password.equals("ProAdmin123");
            if (isAdminAcount) {
                role = ROLE_ADMIN;
            }
            if (!isAdminAcount && clientLogin.getPassword().equals(password)) {
                this.client = clientLogin;
                System.out.println("Client login successfully!");
                role = ROLE_CLIENT;
            }
            if (!clientLogin.getPassword().equals(password)) {
                System.out.println("Wrong password!");
            }
        } while (!clientLogin.getPassword().equals(password));
        return role;
    }

    public void register() {
        Client client = ClientInput.inputClient();
        clientService.create(client);
    }

    public int findIndexAccLog() {
        String username = null;
        Client clientLogin = null;
        try {
            do {
                System.out.print("Enter username: ");
                username = SCANNER.nextLine();
                clientLogin = clientService.findByName(username);
                if (clientLogin == null) {
                    System.out.println("Wrong username!");
                    System.out.println("1. Continue");
                    System.out.println("0. Exit");
                    int choice = SCANNER.nextInt();
                    switch (choice) {
                        case (1) -> SCANNER.nextLine();
                        case (0) -> System.exit(0);
                    }
                }
            } while (clientLogin == null);
        } catch (InputMismatchException e) {
            System.out.println("Input mismatch exception");
        }
        return clientService.findIndexByName(username);
    }

    public boolean checkNull() {
        boolean isNull = false;
        if (Client.getInstance().getListAlbum().size() == 0) {
            isNull = true;
        }
        return isNull;
    }

    public void createNewAlbum() {
        int indexOfAcc = findIndexAccLog();
        if (checkNull()) {
            System.out.println("Enter Album information");
            String albumName;
            boolean invalidAlbumName;
            do {
                System.out.print("Enter new album's name: ");
                albumName = SCANNER.nextLine();
                invalidAlbumName = !Validation.isValid(albumName, Validation.USER_NAME_REGEX);
                if (invalidAlbumName) System.out.println("Wrong format of Album's name! ");
            } while (invalidAlbumName);
            System.out.print("Enter Album's Id: ");
            int albumId = SCANNER.nextInt();
            SCANNER.nextLine();
            Album album = new Album(albumId, albumName);
            clientService.getListClient().get(indexOfAcc).create(album);
            ClientIO.writetoFile(PATH_FILE_CLIENT, clientService.getListClient());
        } else {
            Album album = AlbumInput.inputAlbum();
            clientService.getListClient().get(indexOfAcc).create(album);
            ClientIO.writetoFile(PATH_FILE_CLIENT, clientService.getListClient());
        }
    }

    public void displayAllAlbum() {
        int indexOfAcc = findIndexAccLog();
        if (checkNull()){
            System.out.println("List Album is empty!");
        }else clientService.getListClient().get(indexOfAcc).display();
    }
}

