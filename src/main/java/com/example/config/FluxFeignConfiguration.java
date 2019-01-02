package com.example.config;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shipengfish
 * @description
 * @date 2018/9/11
 * @since 1.0
 */
//@Configuration
public class FluxFeignConfiguration {

    @Bean
    public Contract feignConfiguration() {
        return new feign.Contract.Default();
    }


}
