package com.Input;

import com.model.Client;
import com.model.Validation;
import com.service.Impl.ClientService;

import java.util.Scanner;

public class ClientInput {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static Client inputClient() {
        System.out.println("Enter client information");
        String clientUsername = inputClientUsername();
        String clientPassword = inputClientPassword();
        int clientId = inputClientId();
        SCANNER.nextLine();
        System.out.print("Enter client name: ");
        String clientName = SCANNER.nextLine();
        return new Client(clientId, clientName, clientUsername, clientPassword);
    }

    private static int inputClientId() {
        boolean existId;
        int clientId;
        do {
            System.out.print("Enter client Id: ");
            clientId = SCANNER.nextInt();
            existId = ClientService.getInstance().findById(clientId) != null;
            if (existId) System.out.println("Id already existed!");
        } while (existId);
        return clientId;
    }

    public static String inputClientUsername() {
        String clientUsername;
        boolean existUsername;
        boolean invalidUsername;
        do {
            System.out.print("Enter client username: ");
            clientUsername = SCANNER.nextLine();
            existUsername = ClientService.getInstance().findByName(clientUsername) != null;
            invalidUsername = !Validation.isValid(clientUsername, Validation.USER_NAME_REGEX);
            if (invalidUsername) System.out.println("Wrong format of username! ");
            else if (existUsername) System.out.println("Username already existed! ");
        } while (invalidUsername || existUsername);
        return clientUsername;
    }

    public static String inputClientPassword() {
        String clientPassword;
        boolean invalidPassword;
        do {
            System.out.print("Enter client password: ");
            clientPassword = SCANNER.nextLine();
            invalidPassword = !Validation.isValid(clientPassword, Validation.PASSWORD_REGEX);
            if (invalidPassword) System.out.println("Wrong format of password");
        } while (invalidPassword);
        return clientPassword;
    }
}

