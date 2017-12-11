package com.play.game.code;


import org.springframework.http.HttpStatus;

/**
 * Created by Administrator on 2017/11/21 0021.
 * 异常代码封装
 */
public enum ExceptionCode {

    ADMIN_ARGUMENT_REQUIRED("LOG/ADMIN_ARGUMENT_REQUIRED", "缺少参数: %s不能为空！！", HttpStatus.BAD_REQUEST),
    ARGUMENT_INVALID("TASK/ARGUMENT_INVALID", "请求参数不合法", HttpStatus.BAD_REQUEST);
    private String code;    // 异常代码
    private String message; // 异常信息
    private HttpStatus status; // http 状态码

    ExceptionCode(String code, String message, HttpStatus status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
