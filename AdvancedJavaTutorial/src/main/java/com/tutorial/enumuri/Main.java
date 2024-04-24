package com.tutorial.enumuri;

public class Main {
    public static void main(String[] args) {
        Color blue = Color.BLUE;
        String blueValue = Color.BLUE.getValue();
        System.out.println(blueValue);
        System.out.println(blue);

        for(Color c: Color.values()){
            System.out.println(c + " " + c.getValue());

        }
    }

}
