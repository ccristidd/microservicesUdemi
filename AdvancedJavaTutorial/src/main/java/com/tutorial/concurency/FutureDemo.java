package com.tutorial.concurency;

import java.util.concurrent.*;

public class FutureDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> myFuture = executorService.submit(() -> {
            Thread.sleep(10000);
            return "Completed";
        });

        //the code from this point forward is NOT waiting for the above code
        //because of the different threads.
        try {
            int counter = 0;
            while (!myFuture.isDone()) {
                counter ++;
                System.out.println(counter + " - Task still in progress...wait");
                Thread.sleep(500);
            }
            System.out.println("Task completed!");
            String result = myFuture.get(3000, TimeUnit.MILLISECONDS);//that's the myFuture that was in progress
            System.out.println(result + " myFuture.get(3000, MILLISECONDS)");
            executorService.shutdown();
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            myFuture.cancel(true);
            myFuture.isDone();
            myFuture.isCancelled();
        }
    }
}
