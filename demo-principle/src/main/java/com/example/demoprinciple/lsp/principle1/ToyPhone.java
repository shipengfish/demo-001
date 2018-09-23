package com.example.demoprinciple.lsp.principle1;

/**
 * @author shipengfish
 * @description
 * @date 2018/9/13
 * @since 1.0
 */
public class ToyPhone extends AbstractPhone {

    @Override
    void color() {
        System.out.println("玩具手机蓝色的");
    }

    @Override
    void printShape() {
        System.out.println("玩具手机椭圆形");
    }

    @Override
    void call() {
        System.out.println("玩具手机不能打电话");
    }
}