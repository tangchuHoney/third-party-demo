package com.jklove.demo.exception;

import com.jklove.demo.consts.ResponseStatus;

public class AuthException extends RuntimeException {
    private int errorCode;

    private String errorMsg;

    public AuthException(String errorMsg) {
        this(ResponseStatus.FAILURE.getCode(), errorMsg);
    }

    public AuthException(int errorCode, String errorMsg) {
        super(errorCode + ":" + errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public AuthException(ResponseStatus responseStatus) {
        super(responseStatus.getMsg());
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
