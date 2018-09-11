package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author shipengfish
 * @description
 * @date 2018/9/3
 * @since 1.0
 */
//@Data
@EqualsAndHashCode(callSuper = true)
public class PutSkuDataRequest extends BaseFluxWmsRequest {

    // TODO 增加业务字段.
    private static final long serialVersionUID = -75710749257330857L;
    @Required
    @JsonProperty("CustomerID")
    String customerID;

    @Required
    String name;

    public PutSkuDataRequest(BaseFluxWmsPhpRequest phpRequest, FluxWmsConfig fluxWmsConfig) {
        super(phpRequest, fluxWmsConfig);
    }
}