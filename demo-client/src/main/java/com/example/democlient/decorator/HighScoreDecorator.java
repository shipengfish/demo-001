package com.example.democlient.decorator;

/**
 * @author shipengfish
 * @version 1.0
 * @date 2018/11/26
 * @description
 * @since 1.0
 */
public class HighScoreDecorator extends Decorator {
    public HighScoreDecorator(SchoolReport schoolReport) {
        super(schoolReport);
    }

    private void printHighScore() {
        System.out.println("最高分 100");
    }

    @Override
    void report() {
        printHighScore();
        super.report();
    }
}
