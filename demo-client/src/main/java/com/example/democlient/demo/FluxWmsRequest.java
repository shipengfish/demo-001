package com.example.democlient.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * @author shipengfish
 * @description Flux WMS API 请求对象公共的参数基类.
 * @date 2018/9/3
 * @since 1.0
 */
@Data
@ToString
public class FluxWmsRequest implements Serializable {
    private static final long serialVersionUID = 4615865207972092658L;

    /**
     * 描述: DATAHUB 客户编码. 固定值: FLUXWMSJSON.
     * 是否必填: 是.
     */
//    @JsonProperty("client_customerid")
    protected String client_customerid;

    /**
     * 描述: API 接口名称.
     * 是否必填: 是.
     */
    private String method;

    /**
     * 描述: 接口ID.
     * 是否必填: 是.
     */
    @JsonProperty("messageid")
    private String messageId;

    /**
     * 描述: JSON格式业务数据存放应用级参数数据.
     * 是否必填: 是.
     */
    @JsonProperty("data")
    private String data;

    /**
     * 描述: 仓库DB编码. 固定值: FLUXWMS.
     * 是否必填: 是.
     */
    @JsonProperty("client_db")
    private String clientDb;

    /**
     * 描述: Token 号.
     * 是否必填: 是.
     */
    @JsonProperty("apptoken")
    private String appToken;

    /**
     * 描述: 验签KEY.
     * 是否必填: 是.
     */
    @JsonProperty("appkey")
    private String appKey;

    /**
     * 描述: 验签值.
     * 是否必填: 是.
     */
    @JsonProperty("sign")
    private String sign;

    /**
     * 描述: 报文发送时间,格式 YYYY-MM-DD HH:MM:SS, 该时间与服务端时间误差不得大于10分钟.
     * 是否必填: 是.
     */
    @JsonProperty("timestamp")
    private String timestamp;

    /**
     * 描述: 数据格式, 固定值: json.
     * 是否必填: 是.
     */
    @JsonProperty("format")
    private String format;

    public FluxWmsRequest(String data, ActionType actionType, FluxWmsConfig fluxWmsConfig) {

        Assert.notNull(actionType, "actionType 不能为 null");
        Assert.notNull(fluxWmsConfig, "flux wms config 不能为 null");

        this.data = data;
        this.method = actionType.getMethod();
        this.messageId = actionType.getMessageId();

        Assert.hasText(this.method, "method 不能为空");
        Assert.hasText(this.messageId, "messageId 不能为空");
        Assert.hasText(this.data, "data 不能为空");

        initFields(fluxWmsConfig);
    }

    /**
     * <pre>
     * 初始化字段并且进行签名.
     * </pre>
     */
    private void initFields(FluxWmsConfig config) {
        this.appKey = config.getAppKey();
        this.appToken = config.getAppToken();
        this.timestamp = "";
        this.client_customerid = config.getClientCustomerId();
        this.clientDb = config.getClientDb();
        this.format = config.getFormat();
        this.sign = "";
    }

}