package com.jklove.demo.request;

import com.jklove.demo.config.AuthConfig;
import com.jklove.demo.consts.AuthSource;
import com.jklove.demo.consts.ResponseStatus;
import com.jklove.demo.exception.AuthException;
import com.jklove.demo.factory.AuthorizationFactory;
import com.jklove.demo.model.AuthResponse;
import com.jklove.demo.model.AuthToken;
import com.jklove.demo.model.AuthUser;
import com.jklove.demo.utils.AuthConfigChecker;
import lombok.Data;

@Data
public abstract class BaseAuthRequest implements AuthRequest {

    protected AuthConfig config;
    protected AuthSource source;

    public BaseAuthRequest(AuthConfig config, AuthSource source) {
        this.config = config;
        this.source = source;
        if (!AuthConfigChecker.isSupportAuth(config)) {
            throw new AuthException(ResponseStatus.PARAMETER_INCOMPLETE);
        }
    }

    protected abstract AuthToken getAccessToken(String code);
    protected abstract AuthUser getUserInfo(AuthToken authToken);

    @Override
    public AuthResponse login(String code) {
        try {
            AuthToken accessToken = this.getAccessToken(code);
            AuthUser user = this.getUserInfo(accessToken);
            return AuthResponse.builder().code(ResponseStatus.SUCCESS.getCode()).data(user).build();
        } catch (Exception e) {
            return responseError(e);
        }
    }

    private AuthResponse responseError(Exception e) {
        int errorCode = ResponseStatus.FAILURE.getCode();
        if (e instanceof AuthException) {
            errorCode=  ((AuthException) e).getErrorCode();
        }
        return AuthResponse.builder().code(errorCode).msg(e.getMessage()).build();
    }

    @Override
    public String authorize() {
        return AuthorizationFactory.getAuthorize(source).getAuthorizeUrl(config);
    }


}
