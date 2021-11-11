package com.file;

import com.model.Album;
import com.model.Client;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClientIO {
    public static void writetoFile(String pathFile, List<Client> list) {
        File file = new File(pathFile);
//        FileWriter fileWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//            bufferedWriter.write("Client ID,Client Name,Client Username,Client Password");
            String str = "Client ID,Client Name,Client Username,Client Password,Client Album";
            for (Client client : list) {
                str += "\n" + client.getId() + "," +
                        client.getName() + "," +
                        client.getUsername() + "," +
                        client.getPassword() + ",";
                for (int i = 0; i < client.getListAlbum().size(); i++) {
                    str +=  client.getListAlbum().get(i).getId() + "-" + client.getListAlbum().get(i).getName() + ";";
                }
            }
            bufferedWriter.write(str);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Client> readFromFile(String pathFile) {
        List<Client> clients = new ArrayList<>();
        List<Album> albums = new ArrayList<>();
        File file = new File(pathFile);
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String lineCSV = bufferedReader.readLine();
            while ((lineCSV = bufferedReader.readLine()) != null) {
                String[] lineContent = lineCSV.split(",");
                int clientId = Integer.parseInt(lineContent[0]);
                String clientName = lineContent[1];
                String clientUsername = lineContent[2];
                String clientPassword = lineContent[3];
                String[] albumContent = lineContent[4].split(";");
                for (int i = 0; i < albumContent.length; i++){
                String[] lineAlbumContent = albumContent[i].split("-");
                    int albumId = Integer.parseInt(lineAlbumContent[0]);
                    String albumName = lineAlbumContent[1];
                    Album album = new Album(albumId, albumName);
                    albums.add(album);
                }
                clients.add(new Client(clientId, clientName, clientUsername, clientPassword, albums));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clients;
    }
}
