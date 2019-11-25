package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author shipengfish
 * @version 1.0
 * @date 2019/1/2
 * @description
 * @since 1.0
 */
@Slf4j
public class SignUtil {

    /**
     * 生成跨越接口签名
     *
     * @param t 传输的实体对象
     * @return 签名
     */
    public static <T> String generateKYSign(T t) {
        List<String> signParams = buildSignParams(t);

        log.info("signParams:{}", String.join(",", signParams));

        Collections.sort(signParams);

        String join = String.join("", signParams);

        String p = "C8653B32CB293FED9048A2F7FD822A28" + join;

        return DigestUtils.md5Hex(p).toUpperCase();
    }

    private static <T> List<String> buildSignParams(T t) {

        Objects.requireNonNull(t, "传输对象不能为 null");

        List<Field> fields = Arrays.stream(t.getClass().getDeclaredFields()).collect(Collectors.toList());
        List<Field> superFields = Arrays.asList(t.getClass().getSuperclass().getDeclaredFields());
        fields.addAll(superFields);

        List<String> signParams = new ArrayList<>();
        fields.forEach(field -> {

            // 忽略加了 @JsonIgnore 的字段
            if (field.isAnnotationPresent(JsonIgnore.class)) {
                return;
            }

            boolean isAccessible = field.isAccessible();
            field.setAccessible(true);
            try {
                final Object value = field.get(t);
                String fieldName = field.getName();
                field.setAccessible(isAccessible);
                if (value != null && StringUtils.isNotBlank(value.toString())) {
                    signParams.add(fieldName + value);
                }
            } catch (IllegalAccessException e) {
                log.error("生成签名错误: " + e.getMessage(), e);
            }
        });
        return signParams;
    }

}

