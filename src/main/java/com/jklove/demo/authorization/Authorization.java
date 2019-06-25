package com.jklove.demo.authorization;

import com.jklove.demo.config.AuthConfig;

/**
 * 授权接口  用来获取具体的第三方地址
 */
public interface Authorization {

    /**
     * 获取授权页面地址
     */
    String getAuthorizeUrl(AuthConfig config);
}
