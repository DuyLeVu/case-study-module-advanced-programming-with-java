package com.controller;

import com.Input.ClientInput;
import com.model.Client;
import com.service.Impl.ClientService;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final int ROLE_ADMIN = 2;
    public static final int ROLE_CLIENT = 1;
    private ClientService clientService;
    private Client client;

    public App() {
//        clientService = ClientService.getInstance();
        ArrayList<Client> listStudent = new ArrayList<>();
        clientService = new ClientService(listStudent);
    }

    public ClientService getClientService() {
        return clientService;
    }

    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    public int login() {
        String username;
        Client clientLogin;
        int role = 0;
        do {
            System.out.print("Enter username: ");
            username = SCANNER.nextLine();
            clientLogin = clientService.findByUsername(username);
            if (clientLogin == null) System.out.println("Wrong username!");
        } while (clientLogin == null);

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
//        Client client = ClientInput.inputClient();
        clientService.create(new Client(333,"AdminTest","AdminTest","012345678"));
    }

    public void displayAllClient() {
        clientService.display();
    }
}
