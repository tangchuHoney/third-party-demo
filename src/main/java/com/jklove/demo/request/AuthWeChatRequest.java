package com.jklove.demo.request;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSONObject;
import com.jklove.demo.config.AuthConfig;
import com.jklove.demo.consts.AuthSource;
import com.jklove.demo.consts.AuthUserGender;
import com.jklove.demo.consts.ResponseStatus;
import com.jklove.demo.exception.AuthException;
import com.jklove.demo.model.AuthResponse;
import com.jklove.demo.model.AuthToken;
import com.jklove.demo.model.AuthUser;
import com.jklove.demo.utils.UrlBuilder;

public class AuthWeChatRequest extends BaseAuthRequest {
    public AuthWeChatRequest(AuthConfig config) {
        super(config, AuthSource.WECHAT);
    }

    public AuthWeChatRequest(AuthConfig config, AuthSource resource) {
        super(config,resource);
    }


    /**
     * 微信的特殊性，此时返回的信息同时包含 openid 和 access_token
     *
     * @param code 授权码
     * @return 所有信息
     */
    @Override
    protected AuthToken getAccessToken(String code) {
        String accessTokenUrl = UrlBuilder.getWeChatAccessTokenUrl(config.getClientId(), config.getClientSecret(), code);
        return this.getToken(accessTokenUrl);
    }

    @Override
    protected AuthUser getUserInfo(AuthToken authToken) {
        String accessToken = authToken.getAccessToken();
        String openId = authToken.getOpenId();
        HttpResponse response = HttpRequest.get(UrlBuilder.getWeChatUserInfoUrl(accessToken, openId)).execute();
        JSONObject object = JSONObject.parseObject(response.body());
        this.checkResponse(object);

        return AuthUser.builder()
                .username(object.getString("nickname"))
                .nickname(object.getString("nickname"))
                .avatar(object.getString("headimgurl"))
                .location(object.getString("country") + "-" + object.getString("province") + "-" + object.getString("city"))
                .uuid(openId)
                .gender(AuthUserGender.getRealGender(object.getString("sex")))
                .token(authToken)
                .source(AuthSource.WECHAT)
                .build();
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
    private AuthToken getToken(String accessTokenUrl) {
        HttpResponse response = HttpRequest.get(accessTokenUrl).execute();
        JSONObject object = JSONObject.parseObject(response.body());
        this.checkResponse(object);
        return AuthToken.builder()
                .accessToken(object.getString("access_token"))
                .refreshToken(object.getString("refresh_token"))
                .expireIn(object.getIntValue("expires_in"))
                .openId(object.getString("openid"))
                .build();
    }
}
