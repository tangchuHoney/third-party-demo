package com.jklove.demo.factory;

import com.jklove.demo.authorization.Authorization;
import com.jklove.demo.authorization.WeChatAuthorization;
import com.jklove.demo.authorization.WeChatMinaAuthorization;
import com.jklove.demo.consts.AuthSource;
import com.jklove.demo.consts.ResponseStatus;
import com.jklove.demo.exception.AuthException;

import java.util.HashMap;
import java.util.Map;

/**
 * 授权工厂类，负责创建指定平台的授权类获取授权地址
 * <p>
 * 使用策略模式 + 工厂模式 避免大量的if else（swatch）操作
 *
 */
public class AuthorizationFactory {
    private static Map<String, Authorization> authorizationMap = new HashMap<>();
    private static boolean loader = false;

    public AuthorizationFactory() {
    }

    /**
     * 根据第三方平台，获取具体的授权工具
     *
     * @param source 平台
     * @return 具体的Authorization
     */
    public static Authorization getAuthorize(AuthSource source) {
        if (source == null) {
            throw new AuthException(ResponseStatus.NO_AUTH_SOURCE);
        }
        registerAllAuthorize();
        Authorization authorization = authorizationMap.get(source.toString());
        if (null == authorization) {
            throw new AuthException(ResponseStatus.UNIDENTIFIED_PLATFORM);
        }
        return authorization;
    }
    /**
     * 将所有Authorize的实现类注册到authorizeMap中，
     * 每次增加新的平台都需要在这儿添加注册代码
     */
    private static void registerAllAuthorize() {
        if (loader) {
            return;
        }
//        AuthorizationFactory.register(AuthSource.ALIPAY, new AlipayAuthorization());
//        AuthorizationFactory.register(AuthSource.BAIDU, new BaiduAuthorization());
//        AuthorizationFactory.register(AuthSource.CODING, new CodingAuthorization());
//        AuthorizationFactory.register(AuthSource.CSDN, new CsdnAuthorization());
//        AuthorizationFactory.register(AuthSource.DINGTALK, new DingTalkAuthorization());
//        AuthorizationFactory.register(AuthSource.GITEE, new GiteeAuthorization());
//        AuthorizationFactory.register(AuthSource.GITHUB, new GithubAuthorization());
//        AuthorizationFactory.register(AuthSource.GOOGLE, new GoogleAuthorization());
//        AuthorizationFactory.register(AuthSource.OSCHINA, new OschinaAuthorization());
//        AuthorizationFactory.register(AuthSource.QQ, new QqAuthorization());
//        AuthorizationFactory.register(AuthSource.TAOBAO, new TaobaoAuthorization());
//        AuthorizationFactory.register(AuthSource.TENCENT_CLOUD, new TencentCloudAuthorization());
        AuthorizationFactory.register(AuthSource.WECHAT, new WeChatAuthorization());
        AuthorizationFactory.register(AuthSource.WECHAT_MINA, new WeChatMinaAuthorization());
//        AuthorizationFactory.register(AuthSource.WEIBO, new WeiboAuthorization());
//        AuthorizationFactory.register(AuthSource.FACEBOOK, new FacebookAuthorization());
//        AuthorizationFactory.register(AuthSource.DOUYIN, new DouyinAuthorization());
//        AuthorizationFactory.register(AuthSource.LINKEDIN, new LinkedinAuthorization());
//        AuthorizationFactory.register(AuthSource.MICROSOFT, new MicrosoftAuthorization());
//        AuthorizationFactory.register(AuthSource.MI, new MiAuthorization());
//        AuthorizationFactory.register(AuthSource.TOUTIAO, new ToutiaoAuthorization());
        loader = true;
    }
    private static void register(AuthSource authSource, Authorization authorization) {
        authorizationMap.put(authSource.toString(), authorization);
    }
}
