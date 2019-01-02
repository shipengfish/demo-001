package com.example.democlient.demo;

import lombok.Data;

/**
 * @author shipengfish
 * @version 1.0
 * @date 2018/11/23
 * @description
 * @since 1.0
 */
@Data
public class PurchaseOrderQueryDTO {

    public Integer offset;
    public Integer limit;

    public Integer guid;
    public Integer status;

    public Integer requisitionCode;
    public Integer purchaseCode;
    public Integer sourceCode;

    public Integer expectDeliveryStartTime;
    public Integer expectDeliveryEndTime;

    public Integer requisitionStartTime;
    public Integer requisitionEndTime;

    public Integer auditStartTime;
    public Integer auditEndTime;

    public Integer skuId;
    public Integer productTitle;
    public Integer warehouseId;
    public Integer factoryId;
    public Integer brandId;
    public Integer deliveryMethod;
    public Integer customerReceiveStatus;

    public Integer recipient;

    public Integer recipientMobile;
}
