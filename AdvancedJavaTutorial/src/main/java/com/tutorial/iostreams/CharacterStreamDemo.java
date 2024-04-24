package com.tutorial.iostreams;

import java.io.*;

public class CharacterStreamDemo {
    public static void main(String[] args) throws IOException {
        FileReader reader = null;
        FileWriter writer = null;

        try {
            reader = new FileReader("src/main/resources/source.txt");
            writer = new FileWriter("src/main/resources/destination.txt");
            //read the content of the file until the end of file when it returns -1
            int content;
            while ((content = reader.read()) != -1) {
                writer.append((char) content);
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
    }
}
