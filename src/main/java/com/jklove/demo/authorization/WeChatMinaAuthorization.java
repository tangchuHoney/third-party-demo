package com.jklove.demo.authorization;

import com.jklove.demo.config.AuthConfig;
import com.jklove.demo.utils.UrlBuilder;

/**
 * 微信授权
 */
public class WeChatMinaAuthorization implements Authorization  {
    @Override
    public String getAuthorizeUrl(AuthConfig config) {

        return UrlBuilder.getWeChatMinaAccessTokenUrl(config.getClientId(),config.getClientSecret(),config.getJsCode());
    }
}
