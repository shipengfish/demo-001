package com.example.demoprinciple.lsp.principle1;

/**
 * @author shipengfish
 * @description
 * @date 2018/9/13
 * @since 1.0
 */
public class Client {
    public static void main(String[] args) {
        People p1 = new People(new IPhone());
        p1.callForLeaving();

        System.out.println("---------");

        People p2 = new People(new MiPhone());
        p2.callForLeaving();

        System.out.println("---------");

        People p3 = new People(new ToyPhone());
        p3.callForLeaving();
    }
}