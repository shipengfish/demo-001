package com.example.domain;

import lombok.Data;

/**
 * @author shipengfish
 * @version 1.0
 * @date 2018/12/4
 * @description
 * @since 1.0
 */
@Data
public class RefundRequest {
    private String dataSourceName;
    private String dataSourceKeys;
    private String key;
}
