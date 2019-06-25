package com.jklove.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthToken {
    private String accessToken;
    private int expireIn;
    private String refreshToken;
    private String uid;
    private String openId;
    private String accessCode;

    /**
     * Google附带属性
     */
    private String scope;
    private String tokenType;
    private String idToken;

    /**
     * 小米附带属性
     */
    private String macAlgorithm;
    private String macKey;
    /**
     * 小程序附带属性
     */
    //    //    openid	string	用户唯一标识
////    session_key	string	会话密钥
////    unionid	string	用户在开放平台的唯一标识符，在满足 UnionID 下发条件的情况下会返回，详见 UnionID 机制说明。
////    errcode	number	错误码
////    errmsg	string	错误信息
//    private String openid;
//    private String session_key;
//    private String unionid;
//    private Integer errcode;
//    private String errmsg;
    private String unionid;
    private String sessionKey;

}
