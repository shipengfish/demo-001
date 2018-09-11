package com.example.demo;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Map;

/**
 * @author shipengfish
 * @description
 * @date 2018/9/3
 * @since 1.0
 */
public class SignUtils {

    private static final Logger logger = LoggerFactory.getLogger(SignUtils.class);

    /**
     * 生成的验签字符串
     * 签名使用MD5+base64方式，发送请求时，使用appSecret+data数据+appSecret进行MD5+base64签名，然后对签名结果转大写，最后对转化后的签名数据使用utf-8 字符集urlEncoding。客户系统使用同样方式对接收数据进行校验。如：要发送的XML内容为 “{‘orderinfo’:’test’}”，appSecret为 “12345678”，则data_digest 生成过程如下：
     * 先对“12345678{“orderinfo”:”test”}12345678”这个串先进行MD5加密，得到
     * ba8e94bc10079d74872666f99c924c3d
     * 然后base64签名，得到：YmE4ZTk0YmMxMDA3OWQ3NDg3MjY2NmY5OWM5MjRjM2Q=
     * 签名结果转大写得到：YME4ZTK0YMMXMDA3OWQ3NDG3MJY2NMY5OWM5MJRJM2Q=
     * 对转换后的签名结果使用utf-8 urlEncoding 得到最终签名数据： YME4ZTK0YMMXMDA3OWQ3NDG3MJY2NMY5OWM5MJRJM2Q%3D
     * appSecret：
     * Data：
     *
     * @param appSecret 每个客户的接入加密串，测试时给出
     * @param data      存放每个接口的业务数据
     */
    public static String createSign(String appSecret, String data) {
        String md5Hex = DigestUtils.md5Hex(appSecret + data + appSecret);
        byte[] encode = Base64.getEncoder().encode(md5Hex.getBytes());
        String base64Sign = new String(encode, Charset.defaultCharset()).toUpperCase();
        String sign = null;
        try {
            sign = URLEncoder.encode(base64Sign, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage(), e);
        }
        return sign;
    }

    public static boolean checkSign(Map<String, String> params) {
        String sign = params.get("sign");
        String appSecret = params.get("appSecret");
        String data = params.get("data");
        return sign.equals(createSign(appSecret, data));
    }

    public static void main(String[] args) {
        String md5Hex = DigestUtils.md5Hex("123456");
        System.out.println(md5Hex);

        final String sign = createSign("12345678", "{'orderinfo':'test'}");
        System.out.println(sign);
    }
}