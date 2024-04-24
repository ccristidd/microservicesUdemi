package com.encryptDecrypt;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.iv.RandomIvGenerator;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;


public class EncryptorDecryptor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;
        String inputPassword;
        String inputKey;

        System.out.println("pt criptare apasa 1. Pentru decriptare apasa 2");
        option = sc.nextInt();
        switch (option) {
            case 1 -> {
                System.out.println("Introduceti parola de criptat: ");
                inputPassword = sc.next();
                System.out.println("Introduceti cheia de criptare: ");
                inputKey = sc.next();
                System.out.println(encrypt(inputPassword, inputKey));
            }
            case 2 -> {
                System.out.println("Introduceti parola de decriptat: ");
                inputPassword = sc.next();
                System.out.println("Introduceti cheia de decriptare: ");
                inputKey = sc.next();
                System.out.println(decrypt(inputPassword, inputKey));
            }
        }


//        enc.setAlgorithm("PBEWithHmacSHA512AndAES_256");
//        enc.setIvGenerator(new RandomIvGenerator());
//        enc.setPassword("2uJcv7YiVgLOT19"); //jasypt key
//        final String passwordToEncrypt = "Vikings_2021Pass";
//        final String passwordToDecrypt = "bA0o3L93AIdOpvoTjRK685PZtrcIQVC+05WUxcvp++7b4pfmLKb1HOiTQItK1IphNJgvr0dnLmZqQBVGsir1kA==";
//        final String keyStore = enc.encrypt(passwordToEncrypt);
//        System.out.println("Encrypted password of passwordToEncrypt is: " + keyStore);
//        System.out.println("Decrypted Password of passwordToDecrypt is: " + enc.decrypt(passwordToDecrypt));
    }


    static String encrypt(String toEncrypt, String encryptionKey) {
        StandardPBEStringEncryptor enc = new StandardPBEStringEncryptor();
        enc.setAlgorithm("PBEWithHmacSHA512AndAES_256");
        enc.setIvGenerator(new RandomIvGenerator());
        enc.setPassword(/*"2uJcv7YiVgLOT19"*/ encryptionKey); //jasypt key -> Encryption key for encrypt and decrypt
        return enc.encrypt(toEncrypt);
    }

    static String decrypt(String toDecrypt, String decryptionKey) {
        StandardPBEStringEncryptor enc = new StandardPBEStringEncryptor();
        enc.setAlgorithm("PBEWithHmacSHA512AndAES_256");
        enc.setIvGenerator(new RandomIvGenerator());
        enc.setPassword(/*"2uJcv7YiVgLOT19"*/ decryptionKey); //jasypt key -> Encryption key for encrypt and decrypt
        return enc.decrypt(toDecrypt);
    }
}
