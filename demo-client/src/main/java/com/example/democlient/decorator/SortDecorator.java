package com.example.democlient.decorator;

/**
 * @author shipengfish
 * @version 1.0
 * @date 2018/11/26
 * @description
 * @since 1.0
 */
public class SortDecorator extends Decorator {
    public SortDecorator(SchoolReport schoolReport) {
        super(schoolReport);
    }

    private void printSort() {
        System.out.println("排名 19");
    }

    @Override
    void report() {
        printSort();
        super.report();
    }
}
