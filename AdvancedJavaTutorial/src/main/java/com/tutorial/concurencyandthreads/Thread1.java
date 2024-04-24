package com.tutorial.concurencyandthreads;

public class Thread1 extends Thread{
    MathUtils mu= new MathUtils();

    public Thread1(){}

    public Thread1(MathUtils mu){
        this.mu = mu;
    }

    @Override
    public void run(){
        try{
            System.out.println("Thread1 is running");
            mu.getMultiples(4);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
