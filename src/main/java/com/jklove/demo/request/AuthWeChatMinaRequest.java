package com.jklove.demo.request;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSONObject;
import com.jklove.demo.config.AuthConfig;
import com.jklove.demo.consts.AuthSource;
import com.jklove.demo.consts.ResponseStatus;
import com.jklove.demo.exception.AuthException;
import com.jklove.demo.model.AuthResponse;
import com.jklove.demo.model.AuthToken;
import com.jklove.demo.model.AuthUser;
import com.jklove.demo.utils.UrlBuilder;

public class AuthWeChatMinaRequest extends BaseAuthRequest{
    public AuthWeChatMinaRequest(AuthConfig config) {
        super(config, AuthSource.WECHAT_MINA);
    }


    @Override
    protected AuthToken getAccessToken(String code) {
        String accessTokenUrl = UrlBuilder.getWeChatMinaAccessTokenUrl(config.getClientId(), config.getClientSecret(), code);
        return this.getToken(accessTokenUrl);
    }

    @Override
    protected AuthUser getUserInfo(AuthToken authToken) {
        return null;
    }


    @Override
    public AuthResponse refresh(AuthToken oldToken) {
        String refreshToken = UrlBuilder.getWeChatRefreshUrl(config.getClientId(), oldToken.getRefreshToken());
        return AuthResponse.builder().code(ResponseStatus.SUCCESS.getCode())
                .data(this.getToken(refreshToken))
                .build();
    }

    /**
     * 检查响应内容是否正确
     *
     * @param object 请求响应内容
     */
    private void checkResponse(JSONObject object) {
        if (object.containsKey("errcode")) {
            throw new AuthException(object.getIntValue("errcode"), object.getString("errmsg"));
        }
    }

    /**
     * openid	string	用户唯一标识
     * session_key	string	会话密钥
     * unionid	string	用户在开放平台的唯一标识符，在满足 UnionID 下发条件的情况下会返回，详见 UnionID 机制说明。
     * errcode	number	错误码
     * errmsg	string	错误信息
     * @param accessTokenUrl
     * @return
     */
    public AuthToken getToken(String accessTokenUrl) {
        HttpResponse response = HttpRequest.get(accessTokenUrl).execute();
        JSONObject object = JSONObject.parseObject(response.body());
        this.checkResponse(object);
        return AuthToken.builder()
                .openId(object.getString("openid"))
                .sessionKey(object.getString("session_key"))
                .unionid(object.getString("unionid"))
//                .errcode(Integer.valueOf(object.getString("errcode")))
//                .errmsg(object.getString("errmsg"))
                .build();
    }
}
