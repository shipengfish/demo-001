package com.example.service;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author shipengfish
 * @version 1.0
 * @date 2018/9/24
 * @description
 * @since 1.0
 */
public class ProductService {

    static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Future<Integer> wo = getPriceAsync("wo");
        System.out.println(wo);
        Future<Integer> ni = getPriceAsync("ni");
        System.out.println(ni);

        doOtherThing();

        System.out.println(wo.get());
        System.out.println(ni.get());

        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    private static Future<Integer> getPriceAsync(String productName) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(productName));
    }

    private static Integer calculatePrice(String productName) {
        System.out.println("计算 " + productName + " 的价格");
        try {
            Thread.sleep(TimeUnit.SECONDS.toSeconds(3000));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Random().nextInt(productName.charAt(0));
    }

    private static void doOtherThing() throws InterruptedException {
        System.out.println("do other thing");
    }
}
