package com.example.demo;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import feign.Contract;
import feign.Request;
import feign.Retryer;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.cloud.netflix.feign.support.ResponseEntityDecoder;
import org.springframework.cloud.netflix.feign.support.SpringDecoder;
import org.springframework.cloud.netflix.feign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.io.IOException;

import static com.fasterxml.jackson.databind.PropertyNamingStrategy.SNAKE_CASE;

/**
 * @author shipengfish
 * @description 为了解决使用 {@link feign.RequestLine} 注解引起的 feign RequestLine not annotated with HTTP method type (ex. GET, POST) 问题.
 * @date 2018/9/12
 * @since 1.0
 */
public class FeignOmsConfiguration {
    private static final int CONNECT_TIME_OUT_MILLIS = 30000;//超时时间
    private static final int READ_TIME_OUT_MILLIS = 300000;

    @Bean
    public Request.Options options() {
        return new Request.Options(CONNECT_TIME_OUT_MILLIS, READ_TIME_OUT_MILLIS);
    }

    @Bean
    public Retryer feignRetryer() {
        return new Retryer.Default(100, 1000, 4);
    }

    @Bean
    public Contract feignContract() {
        return new Contract.Default();
    }

    /**
     * 用于将 PHP 返回的结果 decode.
     */
    @Bean(name = "snake_decode")
    public Decoder feignDecoder() {
        HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter();
        ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(jacksonConverter);
        return new ResponseEntityDecoder(new SpringDecoder(objectFactory));
    }

    /**
     * 将请求的驼峰字段转换为下划线.
     */
    @Bean(name = "snake_encode")
    public Encoder feignEncoder(ObjectMapper objectMapper) {
        // null替换为""
        objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(Object arg0, JsonGenerator arg1, SerializerProvider arg2) throws IOException {
                arg1.writeString("");
            }
        });
        ObjectMapper snakeObjectMapper = objectMapper.copy().setPropertyNamingStrategy(SNAKE_CASE);
        HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter(snakeObjectMapper);
        ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(jacksonConverter);
        return new SpringEncoder(objectFactory);
    }
}