package com.example.democlient.baseservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shipengfish
 * @version 1.0
 * @date 2019/2/21
 * @description
 * @since 1.0
 */
@Service
public class BaseAService {

    @Autowired
    private BaseBService baseBService;

    public String hello() {
        return baseBService.say() + "  hello";
    }
}
