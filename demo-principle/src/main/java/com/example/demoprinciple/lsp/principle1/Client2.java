package com.example.demoprinciple.lsp.principle1;

/**
 * @author shipengfish
 * @description 子类出现的地方不一定能出现父类
 * @date 2018/9/13
 * @since 1.0
 */
public class Client2 {

    public static void main(String[] args) {
        callByIPhoneX(new IPhoneX());
//        callByIPhoneX((IPhoneX) new IPhone());
    }

    private static void callByIPhoneX(IPhoneX iPhone) {
        iPhone.call();
    }
}