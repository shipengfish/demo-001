package com.example.demo;

import lombok.Data;

/**
 * @author shipengfish
 * @description
 * @date 2018/9/6
 * @since 1.0
 */
@Data
public abstract class BaseFluxWmsPhpRequest {
    private String data;
    private ActionType actionType;

    public BaseFluxWmsPhpRequest() {
    }

    BaseFluxWmsPhpRequest(String data, ActionType actionType) {
        this.data = data;
        this.actionType = actionType;
    }
}