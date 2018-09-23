package com.example.demoprinciple.lsp.principle1;

/**
 * @author shipengfish
 * @description
 * @date 2018/9/13
 * @since 1.0
 */
public class People {
    private AbstractPhone abstractPhone;

    public People(AbstractPhone abstractPhone) {
        this.abstractPhone = abstractPhone;
    }

    public void callForLeaving() {
        System.out.println("我打电话要请假了");

        abstractPhone.call();

        System.out.println("请假完毕");
    }
}