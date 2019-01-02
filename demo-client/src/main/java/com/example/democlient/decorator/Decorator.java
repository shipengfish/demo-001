package com.example.democlient.decorator;

/**
 * @author shipengfish
 * @version 1.0
 * @date 2018/11/26
 * @description
 * @since 1.0
 */
public class Decorator extends SchoolReport {

    private SchoolReport schoolReport;

    public Decorator(SchoolReport schoolReport) {
        this.schoolReport = schoolReport;
    }

    @Override
    void report() {
        this.schoolReport.report();
    }

    @Override
    void sign() {
        this.schoolReport.sign();
    }
}
