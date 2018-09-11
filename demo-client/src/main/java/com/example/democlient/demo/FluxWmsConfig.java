package com.example.democlient.demo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author shipengfish
 * @description
 * @date 2018/9/3
 * @since 1.0
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "flux.wms")
@PropertySource("classpath:flux-wms.yml")
public class FluxWmsConfig {

    /**
     * 是否使用测试环境.
     */
    @Value("${useTestEnv:false}")
    private boolean useTestEnv = false;

    @Value("${appKey}")
    private String appKey;

    @Value("${appToken}")
    private String appToken;

    @Value("${wmsBaseUrl}")
    private String wmsBaseUrl;

    @Value("${testWmsUrl}")
    private String testWmsUrl;

    @Value("${clientCustomerId:FLUXWMSJSON}")
    private String clientCustomerId;

    @Value("${clientDb:FLUXWMS}")
    private String clientDb;

    @Value("${format:JSON}")
    private String format;
}