package com.example.democlient.decorator;

/**
 * @author shipengfish
 * @version 1.0
 * @date 2018/11/26
 * @description
 * @since 1.0
 */
public class Client {
    public static void main(String[] args) {
        SchoolReport schoolReport = new MySchoolReport();
        schoolReport = new HighScoreDecorator(new SortDecorator(schoolReport));
//        schoolReport = new HighScoreDecorator(schoolReport);
        schoolReport.report();
        schoolReport.sign();
    }
}
