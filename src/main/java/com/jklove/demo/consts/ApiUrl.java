package com.jklove.demo.consts;

import com.jklove.demo.consts.ResponseStatus;
import com.jklove.demo.exception.AuthException;

/**
 * 各api需要的url， 用枚举类分平台类型管理
 *
 * @version 1.0
 * @since 1.0
 */
public enum ApiUrl {
    /**
     * Github
     */
    GITHUB {
        @Override
        public String authorize() {
            return "https://github.com/login/oauth/authorize";
        }

        @Override
        public String accessToken() {
            return "https://github.com/login/oauth/access_token";
        }

        @Override
        public String userInfo() {
            return "https://api.github.com/user";
        }

        @Override
        public String revoke() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }

        @Override
        public String refresh() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }
    },
    /**
     * 新浪微博
     */
    WEIBO {
        @Override
        public String authorize() {
            return "https://api.weibo.com/oauth2/authorize";
        }

        @Override
        public String accessToken() {
            return "https://api.weibo.com/oauth2/access_token";
        }

        @Override
        public String userInfo() {
            return "https://api.weibo.com/2/users/show.json";
        }

        @Override
        public String revoke() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }

        @Override
        public String refresh() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }
    },
    /**
     * gitee
     */
    GITEE {
        @Override
        public String authorize() {
            return "https://gitee.com/oauth/authorize";
        }

        @Override
        public String accessToken() {
            return "https://gitee.com/oauth/token";
        }

        @Override
        public String userInfo() {
            return "https://gitee.com/api/v5/user";
        }

        @Override
        public String revoke() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }

        @Override
        public String refresh() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }
    },
    /**
     * 钉钉
     */
    DINGTALK {
        @Override
        public String authorize() {
            return "https://oapi.dingtalk.com/connect/qrconnect";
        }

        @Override
        public String accessToken() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }

        @Override
        public String userInfo() {
            return "https://oapi.dingtalk.com/sns/getuserinfo_bycode";
        }

        @Override
        public String revoke() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }

        @Override
        public String refresh() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }
    },
    /**
     * 百度
     */
    BAIDU {
        @Override
        public String authorize() {
            return "https://openapi.baidu.com/oauth/2.0/authorize";
        }

        @Override
        public String accessToken() {
            return "https://openapi.baidu.com/oauth/2.0/token";
        }

        @Override
        public String userInfo() {
            return "https://openapi.baidu.com/rest/2.0/passport/users/getInfo";
        }

        @Override
        public String revoke() {
            return "https://openapi.baidu.com/rest/2.0/passport/auth/revokeAuthorization";
        }

        @Override
        public String refresh() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }
    },
    /**
     * csdn
     */
    CSDN {
        @Override
        public String authorize() {
            return "https://api.csdn.net/oauth2/authorize";
        }

        @Override
        public String accessToken() {
            return "https://api.csdn.net/oauth2/access_token";
        }

        @Override
        public String userInfo() {
            return "https://api.csdn.net/user/getinfo";
        }

        @Override
        public String revoke() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }

        @Override
        public String refresh() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }
    },
    /**
     * Coding
     */
    CODING {
        @Override
        public String authorize() {
            return "https://coding.net/oauth_authorize.html";
        }

        @Override
        public String accessToken() {
            return "https://coding.net/api/oauth/access_token";
        }

        @Override
        public String userInfo() {
            return "https://coding.net/api/account/current_user";
        }

        @Override
        public String revoke() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }

        @Override
        public String refresh() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }
    },
    /**
     * 腾讯云开发者平台（coding升级后就变成腾讯云开发者平台了）
     */
    TENCENTCLOUD {
        @Override
        public String authorize() {
            return "https://dev.tencent.com/oauth_authorize.html";
        }

        @Override
        public String accessToken() {
            return "https://dev.tencent.com/api/oauth/access_token";
        }

        @Override
        public String userInfo() {
            return "https://dev.tencent.com/api/account/current_user";
        }

        @Override
        public String revoke() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }

        @Override
        public String refresh() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }
    },
    /**
     * oschina 开源中国
     */
    OSCHINA {
        @Override
        public String authorize() {
            return "https://www.oschina.net/action/oauth2/authorize";
        }

        @Override
        public String accessToken() {
            return "https://www.oschina.net/action/openapi/token";
        }

        @Override
        public String userInfo() {
            return "https://www.oschina.net/action/openapi/user";
        }

        @Override
        public String revoke() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }

        @Override
        public String refresh() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }
    },
    /**
     * 支付宝
     */
    ALIPAY {
        @Override
        public String authorize() {
            return "https://openauth.alipay.com/oauth2/publicAppAuthorize.htm";
        }

        @Override
        public String accessToken() {
            return "https://openapi.alipay.com/gateway.do";
        }

        @Override
        public String userInfo() {
            return "https://openapi.alipay.com/gateway.do";
        }

        @Override
        public String revoke() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }

        @Override
        public String refresh() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }
    },
    /**
     * QQ
     */
    QQ {
        @Override
        public String authorize() {
            return "https://graph.qq.com/oauth2.0/authorize";
        }

        @Override
        public String accessToken() {
            return "https://graph.qq.com/oauth2.0/token";
        }

        @Override
        public String userInfo() {
            return "https://graph.qq.com/user/get_user_info";
        }

        @Override
        public String revoke() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }

        @Override
        public String refresh() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }
    },
    /**
     * 微信
     */
    WECHAT {
        @Override
        public String authorize() {
            return "https://open.weixin.qq.com/connect/qrconnect";
        }

        @Override
        public String accessToken() {
            return "https://api.weixin.qq.com/sns/oauth2/access_token";
        }

        @Override
        public String userInfo() {
            return "https://api.weixin.qq.com/sns/userinfo";
        }

        @Override
        public String revoke() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }

        @Override
        public String refresh() {
            return "https://api.weixin.qq.com/sns/oauth2/refresh_token";
        }
    },
    /**
     * 微信小程序
     */
    WECHAT_MINA {
        /**
         * 调用 wx.login() 获取 临时登录凭证code ，并回传到开发者服务器。
         * 调用 auth.code2Session 接口，换取 用户唯一标识 OpenID 和 会话密钥 session_key。
         * 之后开发者服务器可以根据用户标识来生成自定义登录态，用于后续业务逻辑中前后端交互时识别用户身份。
         *
         * 注意：
         *
         * 会话密钥 session_key 是对用户数据进行 加密签名 的密钥。为了应用自身的数据安全，
         * 开发者服务器不应该把会话密钥下发到小程序，也不应该对外提供这个密钥。
         * 临时登录凭证 code 只能使用一次
         * @return
         */
        @Override
        public String authorize() {
            return "";
        }

        @Override
        public String accessToken() {
            return "https://api.weixin.qq.com/sns/jscode2session";
        }

        @Override
        public String userInfo() {
            return "";
        }

        @Override
        public String revoke() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }

        @Override
        public String refresh() {
            return "";
        }
    },
    /**
     * 淘宝
     */
    TAOBAO {
        @Override
        public String authorize() {
            return "https://oauth.taobao.com/authorize";
        }

        @Override
        public String accessToken() {
            return "https://oauth.taobao.com/token";
        }

        @Override
        public String userInfo() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }

        @Override
        public String revoke() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }

        @Override
        public String refresh() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }
    },
    /**
     * Google
     */
    GOOGLE {
        @Override
        public String authorize() {
            return "https://accounts.google.com/o/oauth2/v2/auth";
        }

        @Override
        public String accessToken() {
            return "https://www.googleapis.com/oauth2/v4/token";
        }

        @Override
        public String userInfo() {
            return "https://oauth2.googleapis.com/tokeninfo";
        }

        @Override
        public String revoke() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }

        @Override
        public String refresh() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }
    },
    /**
     * Facebook
     */
    FACEBOOK {
        @Override
        public String authorize() {
            return "https://www.facebook.com/v3.3/dialog/oauth";
        }

        @Override
        public String accessToken() {
            return "https://graph.facebook.com/v3.3/oauth/access_token";
        }

        @Override
        public String userInfo() {
            return "https://graph.facebook.com/v3.3/me";
        }

        @Override
        public String revoke() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }

        @Override
        public String refresh() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }
    },
    /**
     * 抖音
     */
    DOUYIN {
        @Override
        public String authorize() {
            return "https://open.douyin.com/platform/oauth/connect";
        }

        @Override
        public String accessToken() {
            return "https://open.douyin.com/oauth/access_token";
        }

        @Override
        public String userInfo() {
            return "https://open.douyin.com/oauth/userinfo";
        }

        @Override
        public String revoke() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }

        @Override
        public String refresh() {
            return "https://open.douyin.com/oauth/refresh_token";
        }
    },
    /**
     * 领英
     */
    LINKEDIN {
        @Override
        public String authorize() {
            return "https://www.linkedin.com/oauth/v2/authorization";
        }

        @Override
        public String accessToken() {
            return "https://www.linkedin.com/oauth/v2/accessToken";
        }

        @Override
        public String userInfo() {
            return "https://api.linkedin.com/v2/me";
        }

        @Override
        public String revoke() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }

        @Override
        public String refresh() {
            return "https://www.linkedin.com/oauth/v2/accessToken";
        }
    },
    /**
     * 微软
     */
    MICROSOFT {
        @Override
        public String authorize() {
            return "https://login.microsoftonline.com/common/oauth2/v2.0/authorize";
        }

        @Override
        public String accessToken() {
            return "https://login.microsoftonline.com/common/oauth2/v2.0/token";
        }

        @Override
        public String userInfo() {
            return "https://graph.microsoft.com/v1.0/me";
        }

        @Override
        public String revoke() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }

        @Override
        public String refresh() {
            return "https://login.microsoftonline.com/common/oauth2/v2.0/token";
        }
    },
    /**
     * 小米
     */
    MI {
        @Override
        public String authorize() {
            return "https://account.xiaomi.com/oauth2/authorize";
        }

        @Override
        public String accessToken() {
            return "https://account.xiaomi.com/oauth2/token";
        }

        @Override
        public String userInfo() {
            return "https://open.account.xiaomi.com/user/profile";
        }

        @Override
        public String revoke() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }

        @Override
        public String refresh() {
            return "https://account.xiaomi.com/oauth2/token";
        }
    },
    /**
     * 今日头条
     */
    TOUTIAO {
        @Override
        public String authorize() {
            return "https://open.snssdk.com/auth/authorize";
        }

        @Override
        public String accessToken() {
            return "https://open.snssdk.com/auth/token";
        }

        @Override
        public String userInfo() {
            return "https://open.snssdk.com/data/user_profile";
        }

        @Override
        public String revoke() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }

        @Override
        public String refresh() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }
    };

    /**
     * 授权的api
     *
     * @return url
     */
    public abstract String authorize();

    /**
     * 获取accessToken的api
     *
     * @return url
     */
    public abstract String accessToken();

    /**
     * 获取用户信息的api
     *
     * @return url
     */
    public abstract String userInfo();

    /**
     * 取消授权的api
     *
     * @return url
     */
    public abstract String revoke();

    /**
     * 刷新授权的api
     *
     * @return url
     */
    public abstract String refresh();

}
