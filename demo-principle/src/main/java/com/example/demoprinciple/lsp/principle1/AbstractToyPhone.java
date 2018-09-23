package com.example.demoprinciple.lsp.principle1;

/**
 * @author shipengfish
 * @description
 * @date 2018/9/13
 * @since 1.0
 */
public abstract class AbstractToyPhone {

    AbstractPhone abstractPhone;

    AbstractToyPhone(AbstractPhone abstractPhone) {
        this.abstractPhone = abstractPhone;
    }

    abstract void color();

    abstract void printShape();

    abstract void call();
}