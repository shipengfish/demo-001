package com.example.controller;

import com.example.demo.FluxWmsClient;
import com.example.demo.NeedLog;
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
    public LogController(Decoder decoder, Encoder encoder) {
        fluxWmsClient = Feign.builder()
                .encoder(encoder)
                .decoder(decoder)
                .target(Target.EmptyTarget.create(FluxWmsClient.class));
    }

    @GetMapping("/tt")
    @NeedLog
    public void ttA(PutSkuDataRequest putSkuDataRequest) throws URISyntaxException {
        hha();

        PutSkuDataWmsResponse putSkuDataWmsResponse = fluxWmsClient.putSKUData(new URI("http://localhost:8888" + "/put-sku-data"), putSkuDataRequest);

        System.out.println(putSkuDataWmsResponse);
    }

    private void hha() {
        System.out.println("hhh");
    }
}