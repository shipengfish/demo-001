package com.example.demoprinciple.lsp.principle0;

/**
 * @author shipengfish
 * @description
 * @date 2018/9/14
 * @since 1.0
 */
public class Square extends Rectangle {

    public static void main(String[] args) {
        int area = area(new Square());
        System.out.println(area);
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setLength(width);
    }

    @Override
    public void setLength(int length) {
        super.setWidth(length);
        super.setLength(length);
    }
}