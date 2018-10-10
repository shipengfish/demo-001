package com.example.service;

import java.util.Arrays;

/**
 * @author shipengfish
 * @version 1.0
 * @date 2018/9/24
 * @description
 * @since 1.0
 */
public class Discount {

    public enum Code {
        A(1),
        B(2),
        C(3),
        D(4);
        int ratio;

        Code(int ratio) {
            this.ratio = ratio;
        }

        public int getRatio() {
            return ratio;
        }

        public static Code getCode(String name) {
            return Arrays.stream(Code.values()).filter(a -> a.name().equalsIgnoreCase(name)).findAny().orElse(A);
        }
    }
}
