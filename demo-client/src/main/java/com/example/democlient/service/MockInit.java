package com.example.democlient.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author shipengfish
 * @version 1.0
 * @date 2019-11-25
 * @description
 * @since 1.0
 */
public class MockInit {
    @Test
    public void testRest() {
        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("ADMIN-TOKEN", "ATK191_0bad24045bcb4d0bad2f04561");
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        List<S2bUserInitDTO> initBodyList = getUserInitBodyList();

        initBodyList.forEach(body -> {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("tag", "s2b_mch_user__created");
            jsonObject.put("data", JSON.toJSONString(body));
            HttpEntity<String> formEntity = new HttpEntity<>(JSON.toJSONString(jsonObject), headers);
            String dataFixUrl = "https://uat-newadmin.wzj.com/api/s2b/mq/data-fix";
            template.postForEntity(dataFixUrl, formEntity, Object.class);
        });
    }

    private List<S2bUserInitDTO> getUserInitBodyList() {
        String initMsg = "[{\"merchantIds\":[\"ac94df1a0cfb11ea9b717cd30ad300be\"],\"operator\":\"系统初始化\"}]\n";
        return JSON.parseArray(initMsg, S2bUserInitDTO.class);
    }

}
