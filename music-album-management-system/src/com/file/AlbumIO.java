package com.file;

import com.model.Album;
import com.model.Client;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumIO {
    public static void writetoFile(String pathFile, List<Album> list) {
        File file = new File(pathFile);
//        FileWriter fileWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//            bufferedWriter.write("Client ID,Client Name,Client Username,Client Password");
            String str = "Album ID,Album Name";
            for (Album album:list) {
                str += "\n"+ album.getId() +","+
                        album.getName();
            }
            bufferedWriter.write(str);
            bufferedWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    public static List<Album> readFromFile(String pathFile) {
        List<Album> albums=new ArrayList<>();
        File file=new File(pathFile);
        FileReader fileReader= null;
        try {
            fileReader = new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String lineCSV= bufferedReader.readLine();
            while ((lineCSV=bufferedReader.readLine())!=null){
                String[] lineContent=lineCSV.split(",");
                int albumId=Integer.parseInt(lineContent[0]);
                String albumName=lineContent[1];
                albums.add(new Album(albumId,albumName));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return albums;
    }
}
