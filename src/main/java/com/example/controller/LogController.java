package com.example.controller;

import com.example.demo.FluxWmsClient;
import com.example.domain.RefundRequest;
import com.wozaijia.common.util.IdUtil;
import com.wozaijia.common.util.tuple.Tuple;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.ArrayList;

/**
 * @author shipengfish
 * @description
 * @date 2018/9/10
 * @since 1.0
 */
@RestController
//@Import(FluxFeignConfiguration.class)
public class LogController {
    @Autowired
    private FluxWmsClient fluxWmsClient;

    @GetMapping("/test-feign-a")
    public void testFeign() {
        final ArrayList<Integer> codes = new ArrayList<>();
        codes.add(12);
        fluxWmsClient.testFeign(codes);
    }

    @GetMapping("/refunds")
    public void getRefunds(String dataSourceName, String dataSourceKeys) {
        RefundRequest refundRequest = new RefundRequest();
        refundRequest.setDataSourceKeys(dataSourceKeys);
        refundRequest.setDataSourceName(dataSourceName);
        refundRequest.setKey("this is a key");

        String sign = "abc123";
        String random = "&random=" + IdUtil.uuid16();
        sign = sign + random;
        Tuple.TwoTuple<Integer, Integer> p = fluxWmsClient.getRefunds(refundRequest, sign);

        System.out.println(p);
    }

    @GetMapping("/upload")
    public void upload(@RequestParam("file") MultipartFile multipartFile) {
        System.out.println(multipartFile);
    }

    @PostMapping("/valid")
    public void valid(@RequestBody @Valid ListWrapper<People> peopleListWrapper) {
        System.out.println(peopleListWrapper);
    }
}

class People {
    @NotBlank(message = "name 不能为空")
    private String name;

    @NotBlank(message = "age 不能为空")
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}