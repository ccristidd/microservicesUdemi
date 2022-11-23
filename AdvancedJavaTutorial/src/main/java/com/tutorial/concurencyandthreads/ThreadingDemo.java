package com.tutorial.concurencyandthreads;

public class ThreadingDemo {
    public static void main(String[] args) {
        int n = 10;
        for (int i = 0; i < 10; i++) {
            Thread1 t1 = new Thread1(); //Thread1 is extending thread class
            t1.start();
            Thread t2 = new Thread(new Thread2()); //Thread2 is implementing the Runnable interface
            //t2.run(); prost
            t2.start();


        }
    }

}
