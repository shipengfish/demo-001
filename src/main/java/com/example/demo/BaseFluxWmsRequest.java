package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * @author shipengfish
 * @description Flux WMS API 请求对象公共的参数基类.
 * @date 2018/9/3
 * @since 1.0
 */
@Data
public abstract class BaseFluxWmsRequest implements Serializable {
    private static final long serialVersionUID = 4615865207972092658L;
    /**
     * 描述: DATAHUB 客户编码. 固定值: FLUXWMSJSON.
     * 是否必填: 是.
     */
    @JsonProperty("client_customerid")
    protected String clientCustomerId;

    /**
     * 描述: API 接口名称.
     * 是否必填: 是.
     */
    @Required
    String method;
    /**
     * 描述: 接口ID.
     * 是否必填: 是.
     */
    @JsonProperty("messageid")
    @Required
    String messageId;
    /**
     * 描述: JSON格式业务数据存放应用级参数数据.
     * 是否必填: 是.
     */
    @JsonProperty("data")
    @Required
    String data;
    /**
     * 描述: 仓库DB编码. 固定值: FLUXWMS.
     * 是否必填: 是.
     */
    @JsonProperty("client_db")
    String clientDb;
    /**
     * 描述: Token 号.
     * 是否必填: 是.
     */
    @JsonProperty("apptoken")
    @Required
    String appToken;
    /**
     * 描述: 验签KEY.
     * 是否必填: 是.
     */
    @JsonProperty("appkey")
    @Required
    String appKey;
    /**
     * 描述: 验签值.
     * 是否必填: 是.
     */
    @JsonProperty("sign")
    @Required
    String sign;
    /**
     * 描述: 报文发送时间,格式 YYYY-MM-DD HH:MM:SS, 该时间与服务端时间误差不得大于10分钟.
     * 是否必填: 是.
     */
    @JsonProperty("timestamp")
    @Required
    String timestamp;
    /**
     * 描述: 数据格式, 固定值: json.
     * 是否必填: 是.
     */
    @JsonProperty("format")
    String format;

    BaseFluxWmsRequest(BaseFluxWmsPhpRequest phpRequest, FluxWmsConfig fluxWmsConfig) {
        ActionType actionType = phpRequest.getActionType();
        Assert.notNull(actionType, "actionType 不能为空");
        this.data = phpRequest.getData();
        this.method = actionType.getMethod();
        this.messageId = actionType.getMessageId();
        Assert.hasText(this.method, "method 不能为空");
        Assert.hasText(this.messageId, "messageId 不能为空");
        Assert.hasText(this.data, "data 不能为空");

        initFieldsAndSign(fluxWmsConfig);

        checkFields();
    }

    /**
     * 检查请求参数内容中的必填参数.
     */
    private void checkFields() {
        BeanUtils.checkRequiredFields(this);
    }

    /**
     * <pre>
     * 初始化字段并且进行签名.
     * </pre>
     */
    private void initFieldsAndSign(FluxWmsConfig config) {
        this.appKey = config.getAppKey();
        this.appToken = config.getAppToken();
//        this.timestamp = DateUtil.format(DateUtil.nowSec(), DateUtil.YYYY_MM_DD_HH_MM_SS);
        this.clientCustomerId = config.getClientCustomerId();
        this.clientDb = config.getClientDb();
        this.format = config.getFormat();
        this.setSign(SignUtils.createSign(this.getAppToken(), this.getData()));
    }
}