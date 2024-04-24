package com.tutorial.iostreams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamExample {
    public static void main(String[] args) throws IOException {
        FileInputStream inStream = null;
        FileOutputStream outStream = null;

        try {
            inStream = new FileInputStream("src/main/resources/source.txt");
            outStream = new FileOutputStream("src/main/resources/destination.txt");
            //read the content of the file until the end of file when it returns -1
            int content;
            while ((content = inStream.read()) != -1) {
                outStream.write((byte) content);
            }
        } finally {
            if (inStream != null) {
                inStream.close();
            }
            if (outStream != null) {
                outStream.close();
            }
        }
    }
}
