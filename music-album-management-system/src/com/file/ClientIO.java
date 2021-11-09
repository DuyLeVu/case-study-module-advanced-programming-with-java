package com.file;

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
            String str = "Client ID,Client Name,Client Username,Client Password";
            for (Client client:list) {
               str += "\n"+ client.getId() +","+
                        client.getName()+","+
                        client.getUsername()+","+
                        client.getPassword();
            }
            bufferedWriter.write(str);
            bufferedWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    public static List<Client> readFromFile(String pathFile) {
        List<Client> clients=new ArrayList<>();
        File file=new File(pathFile);
        FileReader fileReader= null;
        try {
            fileReader = new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String lineCSV= bufferedReader.readLine();
            while ((lineCSV=bufferedReader.readLine())!=null){
                String[] lineContent=lineCSV.split(",");
                int clientId=Integer.parseInt(lineContent[0]);
                String clientName=lineContent[1];
                String clientUsername=lineContent[4];
                String clientPassword=lineContent[5];
                clients.add(new Client(clientId,clientName,clientUsername,clientPassword));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clients;
    }
}
