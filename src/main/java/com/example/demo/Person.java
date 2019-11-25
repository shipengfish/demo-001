package com.example.demo;

import lombok.Data;

/**
 * @author shipengfish
 * @version 1.0
 * @date 2019/1/3
 * @description
 * @since 1.0
 */
@Data
public class Person {
    private String name;
}

@Data
class XM extends Person {
    private int age;
}

class T {
    public static void main(String[] args) {
        XM xm = new XM();
        xm.setAge(123);
        xm.setName("xm");

        test(xm);
    }

    public static void test(Person person) {
        final String s = SignUtil.generateKYSign(person);

        System.out.println(person);
    }
}

