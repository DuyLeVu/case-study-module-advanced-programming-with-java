package com.service.Impl;

import com.file.ClientIO;
import com.model.Client;
import com.service.GeneralService;

import java.util.List;

public class ClientService implements GeneralService<Client> {
    private List<Client> listClient;
    private  static ClientService instance;
    public static final  String PATH_FILE_CLIENT = "E:\\Personal\\C0821I1_LeVuDuy\\Module Advanced Programming with Java\\case-study-module-advanced-programming-with-java\\music-album-management-system\\src\\com\\file\\DataClient.csv";

    public ClientService() {

        this.listClient = ClientIO.readFromFile(PATH_FILE_CLIENT);
    }

    public static ClientService getInstance() {
        if (instance == null) instance = new ClientService();
        return instance;
    }

    public List<Client> getListClient() {
        return listClient;
    }

    public void setListClient(List<Client> listClient) {
        this.listClient = listClient;
    }

    public static void setInstance(ClientService instance) {
        ClientService.instance = instance;
    }

    @Override
    public void create(Client client) {
        listClient.add(client);
        ClientIO.writetoFile(PATH_FILE_CLIENT, listClient);
    }

    @Override
    public void delete(String username) {
        int index = findIndexByName(username);
        if (index == -1) System.out.println("This Account is not available");
        else listClient.remove(index);
    }

    @Override
    public void update(String name, String newName) {
        int index = findIndexByName(name);
        if (index == -1) System.out.println("This song is not available");
        else listClient.get(index).setUsername(newName);
    }

    @Override
    public void findByName(String name) {
        for (int i = 0; i < listClient.size(); i++) {
            if (listClient.get(i).getUsername().contains(name)) {
                System.out.println(listClient.get(i));
            }
        }
    }

    @Override
    public List<Client> displayAll() {
        return null;
    }

    @Override
    public void display() {
        for (Client client : listClient){
            System.out.println(client);
        }
    }

    @Override
    public int findIndexByName(String name) {
        int indexOf = -1;
        for (int i = 0; i < listClient.size(); i++) {
            if (listClient.get(i).getUsername().equals(name)) {
                indexOf = i;
                break;
            }
        }
        return indexOf;
    }

    public Client findById(int id) {
        int index = -1;
        for (int i = 0; i < listClient.size(); i++) {
            if (listClient.get(i).getId() == id) {
                index = i;
            }
        }
        if (index == -1) {
            return null;
        } else {
            return listClient.get(index);
        }
    }

    public Client findByUsername(String username) {
        int index=-1;
        for (int i = 0; i < listClient.size(); i++) {
            if(listClient.get(i).getUsername().equals(username)) {
                index=i;
            }
        }
        if(index==-1) {
            return null;
        } else {
            return listClient.get(index);
        }
    }
}
