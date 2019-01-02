package com.example.demo;

import com.example.domain.RefundRequest;
import com.wozaijia.common.util.tuple.Tuple;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.apache.commons.lang3.tuple.MutablePair;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author shipengfish
 * @description 请求 flux wms api 客户端.
 * @date 2018/9/5
 * @since 1.0
 */
@FeignClient(name = "flux-wms", url = "localhost:8888", configuration = FeignOmsConfiguration.class)
public interface FluxWmsClient {

    @RequestLine("GET /test-feign")
    void testFeign(@RequestParam("codes") List<Integer> codes);

    @RequestLine("POST /get-refunds?sign={sign}")
    @Headers({"Content-Type: application/json",
            "key: {request.key}"})
    Tuple.TwoTuple<Integer, Integer> getRefunds(@RequestBody RefundRequest request, @Param("sign") String sign);
}