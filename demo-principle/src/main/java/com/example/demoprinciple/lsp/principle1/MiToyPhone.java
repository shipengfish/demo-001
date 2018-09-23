package com.example.demoprinciple.lsp.principle1;

/**
 * @author shipengfish
 * @description
 * @date 2018/9/13
 * @since 1.0
 */
public class MiToyPhone extends AbstractToyPhone {

    private MiToyPhone(AbstractPhone abstractPhone) {
        super(abstractPhone);
    }

    public static void main(String[] args) {
        MiToyPhone miToyPhone = new MiToyPhone(new MiPhone());
        miToyPhone.color();
        miToyPhone.printShape();
        miToyPhone.call();
    }

    @Override
    void color() {
        abstractPhone.color();
    }

    @Override
    void printShape() {
        abstractPhone.color();
    }

    @Override
    void call() {
        System.out.println("玩具小米手机不能打电话");
    }
}