package com.example.democlient.service;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;

/**
 * @author shipengfish
 * @version 1.0
 * @date 2019-11-18
 * @description
 * @since 1.0
 */
@Data
public class S2bUserInitDTO {
    @NotNull(message = "操作人 不能为空")
    private String operator;

    private List<String> merchantIds;

    public S2bUserInitDTO() {
        // 反序列化使用
    }

    public static void main(String[] args) {
        S2bUserInitDTO initDTO = new S2bUserInitDTO();
        initDTO.setOperator("yyy");
        initDTO.setMerchantIds(Collections.singletonList("asdf"));
        System.out.println(JSON.toJSONString(initDTO));

    }
}
