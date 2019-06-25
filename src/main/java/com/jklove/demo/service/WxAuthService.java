package com.jklove.demo.service;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.jklove.demo.config.AuthConfig;
import com.jklove.demo.consts.AuthSource;
import com.jklove.demo.model.AuthToken;
import com.jklove.demo.model.WxLoginModel;
import com.jklove.demo.model.WxMinaResponse;
import com.jklove.demo.request.AuthWeChatMinaRequest;
import com.jklove.demo.request.AuthWeChatRequest;
import com.jklove.demo.utils.YamlProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class WxAuthService {
    private static String MINA_CLIENT_ID = YamlProperties.getProperty("weixin.mina.appId");
    private static String MINA_SECRET = YamlProperties.getProperty("weixin.mina.secret");


    public ResponseEntity wxLoginByCode(String code) {
        //判断用户名密码是否正确 就是和数据库比对 不写了
        AuthWeChatMinaRequest authWeChatRequest =
                new AuthWeChatMinaRequest(AuthConfig.builder().clientId(MINA_CLIENT_ID).clientSecret(MINA_SECRET).jsCode(code).build());
        String authReqUrl= authWeChatRequest.authorize();
        AuthToken token = authWeChatRequest.getToken(authReqUrl);
        return ResponseEntity.ok(token);
    }
}
