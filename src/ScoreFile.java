package com.codeforall.online.damngame;

import java.io.*;


public class ScoreFile {
    private final String fileName;


    public ScoreFile(String fileName) {
        this.fileName = fileName;
    }

    public void writeFile(String content) {


        try {
            FileWriter fw = new FileWriter(this.fileName);
            fw.write(content);
            fw.close();
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }

    public String readFile() {
        try {
            char[] scoreArray = new char[10];
            FileReader fr = new FileReader(this.fileName);
            fr.read(scoreArray);
            fr.close();

            return new String(scoreArray);

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "0";
    }
}

