package com.file;

import com.model.Song;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SongIO {
    public static void writeToFile(String pathFile, List<Song> list) {
        File file = new File(pathFile);
//        FileWriter fileWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Song ID,Song Name\n");
            for (Song song : list) {
                bufferedWriter.write(song.getId() + "," +
                        song.getName() + "\n");
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Song> readFromFile(String pathFile) {
        List<Song> songs = new ArrayList<>();
        File file = new File(pathFile);
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String lineCSV = bufferedReader.readLine();
            while ((lineCSV = bufferedReader.readLine()) != null) {
                String[] lineContent = lineCSV.split(",");
                int songID = Integer.parseInt(lineContent[0]);
                String songName = lineContent[1];
                songs.add(new Song(songID, songName));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return songs;
    }
}
