package com.example.democlient.controller;

import com.example.democlient.demo.PutSkuDataRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shipengfish
 * @description
 * @date 2018/9/11
 * @since 1.0
 */
@RestController
public class FluxWmsController {

    @PostMapping("/put-sku-data")
    public void putSKUData(@RequestBody PutSkuDataRequest putSkuDataRequest) {
        System.out.println(putSkuDataRequest);
    }
}