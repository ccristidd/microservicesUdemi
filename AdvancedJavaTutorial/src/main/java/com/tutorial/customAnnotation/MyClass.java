package com.tutorial.customAnnotation;

import java.lang.reflect.Method;

public class MyClass {
    @MyCustomAnnotation(value = 10)
    public void sayHello() {
        System.out.println("My custom annotation");
    }

    public static void main(String[] args) throws NoSuchMethodException {
        MyClass m = new MyClass();
        Method methodVal = m.getClass().getMethod("sayHello");

        MyCustomAnnotation myCustomAnnotation = methodVal.getAnnotation(MyCustomAnnotation.class);
        System.out.println(myCustomAnnotation.value());
    }
}
