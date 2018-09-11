package com.example.controller;

import com.example.demo.NeedLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shipengfish
 * @description
 * @date 2018/9/10
 * @since 1.0
 */
@RestController
public class LogController {

    @GetMapping("/tt")
    @NeedLog
    public void ttA(String a) {
        hha();
        System.out.println(a);
        System.out.println(a);
    }

    private void hha() {
        System.out.println("hhh");
    }
}