package com.tutorial.concurency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorAndExecutorService {
    public static void main(String[] args) {
        executorInvoke();
        executorServiceInvoke();

    }

    private static void executorInvoke() {
        Executor executor = new Caller();
        executor.execute(() -> {
            System.out.println("executor example. This is where you tell" +
                    "java what you wand the executor to do");
        });
    }

    private static void executorServiceInvoke() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(() -> {
            System.out.println("executor service example.This is where you tell" +
                    "java what you wand the executor to do");
        });
    }
}
