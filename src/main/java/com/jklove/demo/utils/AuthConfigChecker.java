package com.jklove.demo.utils;

import com.jklove.demo.config.AuthConfig;
import org.apache.commons.lang3.StringUtils;

/**
 * 授权配置类的校验器
 *
 */
public class AuthConfigChecker {
    /**
     * 是否支持第三方登录
     *
     * @param config config
     * @return true or false
     */
    public static boolean isSupportAuth(AuthConfig config) {
        return StringUtils.isNotEmpty(config.getClientId()) && StringUtils.isNotEmpty(config.getClientSecret());
    }
}
