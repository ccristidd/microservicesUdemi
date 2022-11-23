package com.tutorial.concurencyandthreads;

public class Thread2 implements Runnable{

    MathUtils mu=new MathUtils();

    Thread2(){}

    Thread2(MathUtils mu){
        this.mu = mu;
    }
    @Override
    public void run() {

        try{
            System.out.println("Thread2 is running");
            mu.getMultiples(33);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
