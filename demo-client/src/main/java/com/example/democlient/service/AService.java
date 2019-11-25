package com.example.democlient.service;

import com.example.democlient.baseservice.BaseAService;
import org.springframework.stereotype.Service;

/**
 * @author shipengfish
 * @version 1.0
 * @date 2019/2/21
 * @description
 * @since 1.0
 */
@Service
public class AService extends BaseAService {

    private String world() {
        return "world";
    }

    public String helloWorld() {
        return hello() + world();
    }
}
