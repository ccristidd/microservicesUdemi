package com.tutorial.image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagehandlingDemo {
    public static void main(String[] args) throws IOException {
        int width = 963;
        int height = 640;
        BufferedImage image = null;
        image = readFromFile(width, height, image);
        writeToFile(image);
    }

    //static methods can call only other static methods
    private static BufferedImage readFromFile(int width, int height, BufferedImage image) throws IOException {
        File sampleFile = new File("C:\\Users\\ZH07FO\\Documents\\AdvancedJavaTutorial\\src\\main\\resources\\image.jpg");
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        image = ImageIO.read(sampleFile);
        System.out.println("Reading complete. " + image);
        return image;
    }

    //static methods can call only other static methods
    private static void writeToFile(BufferedImage image) throws IOException {
        File output = new File("C:\\Users\\ZH07FO\\Documents\\AdvancedJavaTutorial\\src\\main\\resources\\imageOutput.jpg");
        ImageIO.write(image, "jpg", output);
        System.out.println("Writing complete. ");

    }
}
