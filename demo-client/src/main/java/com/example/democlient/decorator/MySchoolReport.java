package com.example.democlient.decorator;

/**
 * @author shipengfish
 * @version 1.0
 * @date 2018/11/26
 * @description
 * @since 1.0
 */
public class MySchoolReport extends SchoolReport {
    @Override
    void report() {
        System.out.println("我的成绩 80 分");
    }

    @Override
    void sign() {
        System.out.println("请签名");
    }
}
