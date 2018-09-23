package com.example.demoprinciple.lsp.principle2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shipengfish
 * @description
 * @date 2018/9/13
 * @since 1.0
 */
public class Truck extends Car {

    public static void main(String[] args) {
        Car car = new Car();
        car.doTransportation(new ArrayList());

        Truck truck = new Truck();
        truck.doTransportation(new ArrayList());
    }

    public void doTransportation(List list) {
        System.out.println("Truck 运输");
    }

    @Override
    public ArrayList getCount(short i) {
        System.out.println("truck ");
        return null;
    }

}