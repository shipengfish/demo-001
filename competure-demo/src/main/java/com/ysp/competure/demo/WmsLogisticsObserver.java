package com.ysp.competure.demo;

import java.util.Observable;
import java.util.Observer;

/**
 * @author shipengfish
 * @version 1.0
 * @date 2019-07-24
 * @description
 * @since 1.0
 */
public class WmsLogisticsObserver implements Observer {

    private Observable observable;

    public WmsLogisticsObserver(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof LogisticsData) {
            LogisticsData logisticsData = (LogisticsData) o;
            System.out.println(logisticsData);
        }
    }
}


