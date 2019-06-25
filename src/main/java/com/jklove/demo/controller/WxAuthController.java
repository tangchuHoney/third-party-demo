package com.jklove.demo.controller;

import com.jklove.demo.model.WxLoginModel;
import com.jklove.demo.service.WxAuthService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wxauth")
public class WxAuthController {

    @Autowired
    private WxAuthService wxAuthService;



    /**
     * 调用 wx.login() 获取 临时登录凭证code ，并回传到开发者服务器。
     * 调用 auth.code2Session 接口，换取 用户唯一标识 OpenID 和 会话密钥 session_key。
     * 之后开发者服务器可以根据用户标识来生成自定义登录态，用于后续业务逻辑中前后端交互时识别用户身份。
     *
     * 注意：
     *
     * 会话密钥 session_key 是对用户数据进行 加密签名 的密钥。为了应用自身的数据安全，开发者服务器不应该把会话密钥下发到小程序，也不应该对外提供这个密钥。
     * 临时登录凭证 code 只能使用一次
     */
    @RequestMapping(value = "/mina/login", method = RequestMethod.GET)
    public ResponseEntity wxLoginByCode(WxLoginModel wxLoginModel) {
        return wxAuthService.wxLoginByCode(wxLoginModel.getCode());
    }
}
