package com.example.demo;

import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;

/**
 * @author shipengfish
 * @description 请求 flux wms api 客户端.
 * @date 2018/9/5
 * @since 1.0
 */
@FeignClient(name = "flux-wms", url = "#{'${baseUrl:localhost:9999}'}")
public interface FluxWmsClient {

    /**
     * 此接口提供使用FLUX WMS系统的客户系统上传商品目录，支持批量
     * 当OMS系统新增或修改商品时触发该接口，WMS 会根据CustomerID
     * 和SKU字段值判断如果存在则自动更新WMS中商品信息，否则会在WMS
     * 中创建一条商品信息.
     *
     * @param request
     * @param baseUri
     */
//    @RequestMapping(method = RequestMethod.POST, value = "/put-sku-data")
    @RequestLine("POST")
    PutSkuDataWmsResponse putSKUData(URI baseUri, @RequestBody PutSkuDataRequest request);
}