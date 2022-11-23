package com.tutorial.generics;

public class DualGenericHolder <T,U>{
    T obiect1;
    U obiect2;

    DualGenericHolder(T obj1, U obj2){
        this.obiect1 = obj1;
        this.obiect2 = obj2;
    }

    public void display(){
        System.out.println(obiect1);
        System.out.println(obiect2);
    }

    public static void main(String[] args) {
        DualGenericHolder<String, Integer> obj =
                new DualGenericHolder<>("obiect1", 20);
        obj.display();
    }
}
