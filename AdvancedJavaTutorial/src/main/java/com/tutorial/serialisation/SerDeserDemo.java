package com.tutorial.serialisation;

import java.io.*;

public class SerDeserDemo {
    public static void main(String[] args) throws FileNotFoundException {
        Student student = new Student("John", "male", 38, "strada nume, oras, tara", 78);

        File file = new File("src/main/resources/Test.txt");
        String filename = "src/main/resources/Test.txt";
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        //Serialization
        try {
            fileOutputStream = new FileOutputStream(filename);
            FileOutputStream fileOutputStreamf = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(student);

//            objectOutputStream = new ObjectOutputStream(fileOutputStreamf);
//            objectOutputStream.writeObject(student);

            objectOutputStream.close();
            fileOutputStream.close();

            System.out.println("object has been serialized - check file" + student);

        } catch (Exception e) {
            e.printStackTrace();
        }

        //Deserialization
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream(filename);
            objectInputStream = new ObjectInputStream(fileInputStream);
            Student object = (Student) objectInputStream.readObject();
            System.out.println("object has been deserialized " + object);

            objectInputStream.close();
            fileInputStream.close();

        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}
