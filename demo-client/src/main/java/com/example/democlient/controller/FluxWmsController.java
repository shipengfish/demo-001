package com.example.democlient.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.democlient.demo.FluxWmsRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author shipengfish
 * @description
 * @date 2018/9/11
 * @since 1.0
 */
@RestController
public class FluxWmsController {

    @PostMapping("/")
    public JSONObject putSKUData(@RequestBody FluxWmsRequest putSkuDataRequest) {
        System.out.println(JSON.toJSONString(putSkuDataRequest));
        System.out.println(putSkuDataRequest);

        if ("putSKUData".equalsIgnoreCase(putSkuDataRequest.getMethod())) {
            return buildPutSkuResp();
        }
        if ("putCustData".equals(putSkuDataRequest.getMethod())) {
            return buildPutCustResp();
        }
        if ("putASNData".equals(putSkuDataRequest.getMethod())) {
            return putASNData();
        }
        if ("putSOData".equals(putSkuDataRequest.getMethod())) {
            return putSOData();
        }
        if ("querySOStatus".equals(putSkuDataRequest.getMethod())) {
            return querySOStatus();
        }
        if ("confirmSOStatus".equals(putSkuDataRequest.getMethod())) {
            return confirmSOStatus();
        }
        if ("cancelASNData".equals(putSkuDataRequest.getMethod())) {
            return cancelASNData();
        }
        if ("cancelSOData".equals(putSkuDataRequest.getMethod())) {
            return cancelSOData();
        }
        if ("queryINVData".equals(putSkuDataRequest.getMethod())) {
            return queryINVData();
        }
        return null;
    }

    private JSONObject buildPutSkuResp() {
        List<String> strings = new ArrayList<>();
        strings.add("{\"Response\":{\"return\":{\"returnCode\":\"0000\",\"returnDesc\":\"ok\",\"returnFlag\":\"1\",\"resultInfo\":\"\"}}}");
        strings.add("{\"Response\":{\"return\":{\"returnCode\":\"0001\",\"returnDesc\":\"错误原因\",\"returnFlag\":\"0\",\"resultInfo\":\"\"}}}");
        strings.add("{\"Response\":{\"return\":{\"returnCode\":\"0001\",\"returnDesc\":\"错误原因\",\"returnFlag\":\"2\",\"resultInfo\":[{\"CustomerID\":\"\",\"SKU\":\"\",\"errorcode\":\"\",\"errordescr\":\"\"},{\"CustomerID\":\"\",\"SKU\":\"\",\"errorcode\":\"\",\"errordescr\":\"\"}]}}}");
        Collections.shuffle(strings);
        return JSON.parseObject(strings.get(0));
    }

    private JSONObject buildPutCustResp() {
        List<String> strings = new ArrayList<>();
        strings.add("{\"Response\":{\"return\":{\"returnCode\":\"0000\",\"returnDesc\":\"ok\",\"returnFlag\":\"1\",\"resultInfo\":\"\"}}}");
        strings.add("{\"Response\":{\"return\":{\"returnCode\":\"0001\",\"returnDesc\":\"错误原因\",\"returnFlag\":\"0\",\"resultInfo\":\"\"}}}");
        strings.add("{\"Response\":{\"return\":{\"returnCode\":\"0001\",\"returnDesc\":\"错误原因\",\"returnFlag\":\"2\",\"resultInfo\":[{\"CustomerID\":\"\",\"Customer_Type\":\"\",\"errorcode\":\"\",\"errordescr\":\"\"},{\"CustomerID\":\"\",\"Customer_Type\":\"\",\"errorcode\":\"\",\"errordescr\":\"\"}]}}}");
        Collections.shuffle(strings);
        return JSON.parseObject(strings.get(0));
    }

    private JSONObject putASNData() {
        List<String> strings = new ArrayList<>();
        strings.add("{\"Response\":{\"return\":{\"returnCode\":\"0000\",\"returnDesc\":\"ok\",\"returnFlag\":\"1\",\"resultInfo\":\"\"}}}");
        strings.add("{\"Response\":{\"return\":{\"returnCode\":\"0001\",\"returnDesc\":\"错误原因\",\"returnFlag\":\"0\",\"resultInfo\":\"\"}}}");
        strings.add("{\"Response\":{\"return\":{\"returnCode\":\"0001\",\"returnDesc\":\"错误原因\",\"returnFlag\":\"2\",\"resultInfo\":[{\"OrderNo\":\"A001\",\"OrderType\":\"CM\",\"CustomerID\":\"TEST\",\"WarehouseID\":\"\",\"errorcode\":\"\",\"errordescr\":\"\"},{\"OrderNo\":\"A002\",\"OrderType\":\"CM\",\"CustomerID\":\"TEST\",\"WarehouseID\":\"\",\"errorcode\":\"\",\"errordescr\":\"\"}]}}}");
        Collections.shuffle(strings);
        return JSON.parseObject(strings.get(0));
    }

    private JSONObject putSOData() {
        List<String> strings = new ArrayList<>();
        strings.add("{\"Response\":{\"return\":{\"returnCode\":\"0000\",\"returnDesc\":\"ok\",\"returnFlag\":\"1\",\"resultInfo\":\"\"}}}");
        strings.add("{\"Response\":{\"return\":{\"returnCode\":\"0001\",\"returnDesc\":\"错误原因\",\"returnFlag\":\"0\",\"resultInfo\":\"\"}}}");
        strings.add("{\"Response\":{\"return\":{\"returnCode\":\"0001\",\"returnDesc\":\"错误原因\",\"returnFlag\":\"2\",\"resultInfo\":[{\"OrderNo\":\"A001\",\"OrderType\":\"OD\",\"CustomerID\":\"TEST\",\"WarehouseID\":\"\",\"errorcode\":\"\",\"errordescr\":\"\"},{\"OrderNo\":\"A002\",\"OrderType\":\"OD\",\"CustomerID\":\"TEST\",\"WarehouseID\":\"\",\"errorcode\":\"\",\"errordescr\":\"\"}]}}}");
        Collections.shuffle(strings);
        return JSON.parseObject(strings.get(0));
    }

    private JSONObject querySOStatus() {
        List<String> strings = new ArrayList<>();
        strings.add("{\"Response\":{\"return\":{\"returnCode\":\"0000\",\"returnDesc\":\"ok\",\"returnFlag\":\"1\"},\"ordernos\":{\"orderinfo\":[{\"OrderNo\":\"\",\"OrderType\":\"\",\"CustomerID\":\"\",\"WarehouseID\":\"\",\"Status\":\"\",\"Desc\":\"\",\"Time\":\"\",\"Udf1\":\"\",\"Udf2\":\"\",\"Udf3\":\"\",\"Udf4\":\"\",\"Udf5\":\"\",\"Udf6\":\"\",\"Udf7\":\"\",\"Udf8\":\"\",\"Udf9\":\"\",\"Udf10\":\"\"}]}}}");
        strings.add("{\"Response\":{\"return\":{\"returnCode\":\"0001\",\"returnDesc\":\"错误原因\",\"returnFlag\":\"0\"}}}");
        Collections.shuffle(strings);
        return JSON.parseObject(strings.get(0));
    }

    private JSONObject confirmSOStatus() {
        List<String> strings = new ArrayList<>();
        strings.add("{\"Response\":{\"return\":{\"returnCode\":\"0000\",\"returnDesc\":\"ok\",\"returnFlag\":\"1\"}}}");
        strings.add("{\"Response\":{\"return\":{\"returnCode\":\"0001\",\"returnDesc\":\"错误原因\",\"returnFlag\":\"0\"}}}");
        strings.add("{\"Response\":{\"return\":{\"returnCode\":\"0001\",\"returnDesc\":\"错误原因\",\"returnFlag\":\"2\",\"resultInfo\":[{\"OrderNo\":\"\",\"OrderType\":\"\",\"CustomerID\":\"\",\"WarehouseID\":\"\",\"Status\":\"\",\"errorcode\":\"\",\"errordescr\":\"\"},{\"OrderNo\":\"\",\"OrderType\":\"\",\"CustomerID\":\"\",\"WarehouseID\":\"\",\"Status\":\"\",\"errorcode\":\"\",\"errordescr\":\"\"}]}}}");
        Collections.shuffle(strings);
        return JSON.parseObject(strings.get(0));
    }

    private JSONObject cancelASNData() {
        List<String> strings = new ArrayList<>();
        strings.add("{\"Response\":{\"return\":{\"returnCode\":\"0000\",\"returnDesc\":\"ok\",\"returnFlag\":\"1\"}}}");
        strings.add("{\"Response\":{\"return\":{\"returnCode\":\"0001\",\"returnDesc\":\"错误原因\",\"returnFlag\":\"0\"}}}");
        Collections.shuffle(strings);
        return JSON.parseObject(strings.get(0));
    }

    private JSONObject cancelSOData() {
        List<String> strings = new ArrayList<>();
        strings.add("{\"Response\":{\"return\":{\"returnCode\":\"0000\",\"returnDesc\":\"ok\",\"returnFlag\":\"1\"}}}");
        strings.add("{\"Response\":{\"return\":{\"returnCode\":\"0001\",\"returnDesc\":\"错误原因\",\"returnFlag\":\"0\"}}}");
        Collections.shuffle(strings);
        return JSON.parseObject(strings.get(0));
    }

    private JSONObject queryINVData() {
        List<String> strings = new ArrayList<>();
        strings.add("{\"Response\":{\"return\":{\"returnCode\":\"0000\",\"returnDesc\":\"ok\",\"returnFlag\":\"1\",\"resultInfo\":\"120\"},\"items\":{\"item\":[{\"CustomerID\":\"\",\"WarehouseID\":\"\",\"SKU\":\"\",\"Qty\":\"\",\"Qty_EA\":\"\",\"QtyAllocated\":\"\",\"Lotatt01\":\"\",\"Lotatt02\":\"\",\"Lotatt03\":\"\",\"Lotatt04\":\"\",\"Lotatt05\":\"\",\"Lotatt06\":\"\",\"Lotatt07\":\"\",\"Lotatt08\":\"\",\"Lotatt09\":\"\",\"Lotatt10\":\"\",\"Lotatt11\":\"\",\"Lotatt12\":\"\",\"Udf1\":\"\",\"Udf2\":\"\",\"Udf3\":\"\",\"Udf4\":\"\",\"Udf5\":\"\",\"Udf6\":\"\",\"Udf7\":\"\",\"Udf8\":\"\",\"Udf9\":\"\",\"Udf10\":\"\"}]}}}");
        strings.add("{\"Response\":{\"return\":{\"returnCode\":\"0001\",\"returnDesc\":\"错误原因\",\"returnFlag\":\"0\"}}}");
        Collections.shuffle(strings);
        return JSON.parseObject(strings.get(0));
    }
}