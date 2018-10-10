package com.example.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author shipengfish
 * @version 1.0
 * @date 2018/9/24
 * @description
 * @since 1.0
 */
public class CompletbleTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Object join = CompletableFuture.allOf(test2(), test1()).join();
        System.out.println(join);
    }

    public static CompletableFuture<String> test1() {
        try {
            Thread.sleep(TimeUnit.SECONDS.toSeconds(10));
            System.out.println("do test 1 ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture("Hello World 1");
    }

    public static CompletableFuture<String> test2() {
        try {
            Thread.sleep(TimeUnit.SECONDS.toSeconds(5));
            System.out.println("do test 2 ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture("Hello World 2");
    }
}
