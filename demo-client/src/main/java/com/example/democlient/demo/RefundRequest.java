package com.example.democlient.demo;

import lombok.Data;
import lombok.ToString;

/**
 * @author shipengfish
 * @version 1.0
 * @date 2018/12/4
 * @description
 * @since 1.0
 */
@Data
@ToString
public class RefundRequest {
    private String data_source_name;
    private String data_source_keys;
}
