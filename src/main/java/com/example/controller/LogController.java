package com.example.controller;

import com.example.demo.FluxWmsClient;
import com.example.demo.FluxWmsConfig;
import com.example.demo.NeedLog;
import com.example.demo.PutSkuDataPhpRequest;
import com.example.demo.PutSkuDataRequest;
import com.example.demo.PutSkuDataWmsResponse;
import feign.Feign;
import feign.Target;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author shipengfish
 * @description
 * @date 2018/9/10
 * @since 1.0
 */
@RestController
@Import(FeignClientsConfiguration.class)
public class LogController {
    @Autowired
    private FluxWmsClient fluxWmsClient;
    @Autowired
    private FluxWmsConfig fluxWmsConfig;

    @Autowired
    public LogController(Decoder decoder, Encoder encoder) {
        fluxWmsClient = Feign.builder()
                .encoder(encoder)
                .decoder(decoder)
                .target(Target.EmptyTarget.create(FluxWmsClient.class));
    }

    public String getFluxWmsBaseUrl() {
        if (fluxWmsConfig.isUseTestEnv()) {
            return fluxWmsConfig.getTestWmsUrl();
        }
        return fluxWmsConfig.getWmsBaseUrl();
    }

    @GetMapping("/tt")
    @NeedLog
    public void ttA(PutSkuDataPhpRequest fluxWmsPhpRequest) throws URISyntaxException {
        hha();
        PutSkuDataRequest putSkuDataRequest = new PutSkuDataRequest(fluxWmsPhpRequest, fluxWmsConfig);

        PutSkuDataWmsResponse putSkuDataWmsResponse = fluxWmsClient.putSKUData(new URI(getFluxWmsBaseUrl() + "/put-sku-data"), putSkuDataRequest);

        System.out.println(putSkuDataWmsResponse);
    }

    private void hha() {
        System.out.println("hhh");
    }
}