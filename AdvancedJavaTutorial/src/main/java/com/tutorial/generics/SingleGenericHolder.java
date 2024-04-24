package com.tutorial.generics;

public class SingleGenericHolder <T>{
    private T obiect;
    SingleGenericHolder(T obj){
        this.obiect=obj;
    }

    public T getObiect(){
        return this.obiect;
    }

    public static void main(String[] args) {
        //cream 2 obiecte diferite din aceeasi clasa pt ca am definit clasa cu generic
        SingleGenericHolder<String> stringObiect =
                new SingleGenericHolder<>("StringObiect");
        System.out.println(stringObiect.getObiect());
        SingleGenericHolder<Integer> integerObiect =
                new SingleGenericHolder<>(10);
        System.out.println(integerObiect.getObiect());
    }
}
