package com.jklove.demo.model;

import com.jklove.demo.consts.ResponseStatus;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AuthResponse<T> {
    /**
     * 授权响应状态码
     */
    private int code;

    /**
     * 授权响应信息
     */
    private String msg;

    /**
     * 授权响应的数据  当code = 2000 时返回
     */
    private T data;

    /**
     * 是否请求成功
     */

    public boolean ok() {
        return this.code == ResponseStatus.SUCCESS.getCode();
    }

}
