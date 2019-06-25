package com.jklove.demo.authorization;

import com.jklove.demo.config.AuthConfig;
import com.jklove.demo.utils.UrlBuilder;

/**
 * 微信授权
 */
public class WeChatAuthorization implements Authorization  {
    @Override
    public String getAuthorizeUrl(AuthConfig config) {

        return UrlBuilder.getWeChatAuthorizeUrl(config.getClientId(),config.getRedirectUrl());
    }
}
