package com.example.service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @author shipengfish
 * @version 1.0
 * @date 2018/9/24
 * @description
 * @since 1.0
 */
public class Shop {


    static List<Shop> shopList = Arrays.asList(new Shop("A"), new Shop("B"),
            new Shop("C"), new Shop("D"), new Shop("E"), new Shop("F"),
            new Shop("G"), new Shop("H"), new Shop("I"), new Shop("J")
    );

//    static ExecutorService executors = Executors.newFixedThreadPool(Math.min(shopList.size(), 100));

    static ExecutorService executors = Executors.newFixedThreadPool(Math.min(shopList.size(), 100), r -> {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
    });

    private String name;

    private Discount.Code code;

    public Shop(String name) {
        this.name = name;
        Discount.Code[] values = Discount.Code.values();
        this.code = values[new Random().nextInt(values.length)];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getDiscount(String shop) {
        randomDelay();
        String[] split = shop.split(":");
        return "商品: " + split[0] + "原价: " + Integer.valueOf(split[1]) + " 现价: " + (Integer.valueOf(split[1])) * (Discount.Code.getCode(split[2]).getRatio());
    }

    private Integer calculatePrice(String productName) {
        System.out.println(name + " 执行时间 " + randomDelay());
        return new Random().nextInt(productName.charAt(0));
    }

    private static int randomDelay() {
        try {
            int duration = 500 + new Random().nextInt(2000);
            Thread.sleep(TimeUnit.SECONDS.toSeconds(duration));
            return duration;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {

//        long start = System.currentTimeMillis();
//        List<String> wzj = findShops("WZJ");
//        System.out.println(wzj);
//        System.out.println("耗费时间: " + (System.currentTimeMillis() - start));
//
//        long start2 = System.currentTimeMillis();
//        List<String> wzj2 = findShopsParallel("WZJ2");
//        System.out.println(wzj2);
//        System.out.println("耗费时间: " + (System.currentTimeMillis() - start2));

        long start3 = System.currentTimeMillis();
        List<String> wzj3 = findShopsCompletableFuture("WZJ3");
        System.out.println(wzj3);
        System.out.println("耗费时间: " + (System.currentTimeMillis() - start3));

        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    private static List<String> findShops(String productName) {
        return shopList.stream().map(shop -> (shop.getName() + shop.calculatePrice(productName))).collect(toList());
    }

    private static List<String> findShopsParallel(String productName) {
        return shopList.stream().parallel()
                .map(shop -> (shop.getName() + ":" + shop.calculatePrice(productName) + ":" + shop.code))
                .map(Shop::getDiscount)
                .collect(toList());
    }

    private static List<String> findShopsCompletableFuture(String productName) {
        List<CompletableFuture<String>> collect = shopList.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getName() + ":" + shop.calculatePrice(productName) + ":" + shop.code, executors))
                .map(future -> future.thenApply(Shop::getDiscount)).collect(Collectors.toList());

        return collect.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }
}
