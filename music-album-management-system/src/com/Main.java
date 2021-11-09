package com;

import com.controller.App;
import com.model.Client;
import com.service.Impl.ClientService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static final Scanner SCANNER = new Scanner(System.in);
    private static ClientService clientService;

    public static void main(String[] args) {
        // write your code here
        App app = new App();
        int choice_1;
        boolean check_1 = false;
        try {
            do {
                menu_1();
                System.out.print("Enter your choice 1: ");
                choice_1 = SCANNER.nextInt();
                SCANNER.nextLine();
                switch (choice_1) {
                    case 1:
                        if (app.login() == 1) {
                            int choice_2;
                            do {
                                menu_2();
                                System.out.print("Enter your choice 2: ");
                                choice_2 = SCANNER.nextInt();
                                SCANNER.nextLine();
                                switch (choice_2) {
                                    case 1: {
                                        app.displayAllClient();
                                        break;
                                    }
                                }
                            } while (choice_2 <= 3 && choice_2 >= 1);
                        }
                        break;
                    case 2:
                        app.register();
                        break;
                    case 3:
                        System.out.println("Bye");
                        break;
                }
            } while (!check_1);
        } catch (InputMismatchException e) {
            System.out.println("Input mismatch exception");
        }
    }


    public static void menu_1() {
        System.out.println("-----------------------------MENU_1--------------------------------");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");

    }

    public static void menu_2() {
        System.out.println("-----------------------------MENU_2--------------------------------");
        System.out.println("1. Show all Client");
        System.out.println("2. Hello");
        System.out.println("3. GoodBye");
    }

}
