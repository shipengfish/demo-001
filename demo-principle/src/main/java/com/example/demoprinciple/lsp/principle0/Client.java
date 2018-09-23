package com.example.demoprinciple.lsp.principle0;

/**
 * @author shipengfish
 * @description
 * @date 2018/9/13
 * @since 1.0
 */
public class Client {

    public static void main(String[] args) {
        StoreInFactory storeInFactory = new StoreInFactory(new StoreInGenerator());
        storeInFactory.generate();
    }
}