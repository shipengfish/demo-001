package com.example.demo;

/**
 * @author shipengfish
 * @description
 * @date 2018/9/6
 * @since 1.0
 */
public enum ActionType {
    PUT_SKU_DATA("putSKUData", "SKU");

    private String method;
    private String messageId;

    ActionType(String method, String messageId) {
        this.method = method;
        this.messageId = messageId;
    }

    public String getMethod() {
        return method;
    }

    public String getMessageId() {
        return messageId;
    }
}