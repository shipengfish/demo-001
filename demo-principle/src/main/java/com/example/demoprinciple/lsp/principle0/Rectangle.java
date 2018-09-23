package com.example.demoprinciple.lsp.principle0;

/**
 * @author shipengfish
 * @description
 * @date 2018/9/13
 * @since 1.0
 */
public class Rectangle {

    private int width;
    private int length;

    public static int area(Rectangle rectangle) {
        rectangle.setLength(4);
        rectangle.setWidth(5);
        return rectangle.getLength() * rectangle.getLength();
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}