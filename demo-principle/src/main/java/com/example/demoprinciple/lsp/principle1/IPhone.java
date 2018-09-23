package com.example.demoprinciple.lsp.principle1;

/**
 * @author shipengfish
 * @description
 * @date 2018/9/13
 * @since 1.0
 */
public class IPhone extends AbstractPhone {

    @Override
    void color() {
        System.out.println("苹果手机银色");
    }

    @Override
    void printShape() {
        System.out.println("苹果手机长方形");
    }

    @Override
    void call() {
        System.out.println("苹果手机打电话");
    }
}