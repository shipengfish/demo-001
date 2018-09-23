package com.example.demoprinciple.lsp.principle1;

/**
 * @author shipengfish
 * @description
 * @date 2018/9/13
 * @since 1.0
 */
public class MiPhone extends AbstractPhone {

    @Override
    void color() {
        System.out.println("小米手机黄色");
    }

    @Override
    void printShape() {
        System.out.println("小米手机长方形");
    }

    @Override
    void call() {
        System.out.println("小米手机打电话");
    }
}