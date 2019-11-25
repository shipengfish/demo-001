package com.ysp.competure.demo;

import java.util.Observable;

/**
 * @author shipengfish
 * @version 1.0
 * @date 2019-07-24
 * @description
 * @since 1.0
 */
public class LogisticsData extends Observable {
    private String companyCode;
    private String waybillNo;

    public void setLogisticsData(String companyCode, String waybillNo) {
        this.companyCode = companyCode;
        this.waybillNo = waybillNo;
        update();
    }

    public void update() {
        setChanged();
        super.notifyObservers();
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getWaybillNo() {
        return waybillNo;
    }

    public void setWaybillNo(String waybillNo) {
        this.waybillNo = waybillNo;
    }

    public static void main(String[] args) {
        LogisticsData logisticsData = new LogisticsData();
        WmsLogisticsObserver observer = new WmsLogisticsObserver(logisticsData);
        logisticsData.setLogisticsData("ysp", "1243");
    }
}
