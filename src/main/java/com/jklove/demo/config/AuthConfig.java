package com.jklove.demo.config;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthConfig {
    /**
     * 客户端id  对应平台的appKey
     */
    private String clientId;

    /**
     * 客户端Secret 对应每个平台的SecretKey
     */
    private String clientSecret;

    /**
     * 登陆成功后回调地址
     */
    private String redirectUrl;

    /**
     * 支付宝公钥  当选择支付宝时候  该值可用
     */
    private String aliPayPublicKey;
    /**
     * 小程序端 jscode
     */
    private String jsCode;
}
