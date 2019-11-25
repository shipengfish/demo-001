package com.example.democlient.controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author shipengfish
 * @version 1.0
 * @date 2019-09-10
 * @description
 * @since 1.0
 */
@RestController
public class TestController {

    @PutMapping("/tttt")
    public void put(@Valid @RequestBody CustomerGroupRequest request) {
        System.out.println(request);
    }

    @PutMapping("/ttttt")
    public void add(@Valid @RequestBody CustomerGroupRequest request) {
        System.out.println(request);
    }
}
