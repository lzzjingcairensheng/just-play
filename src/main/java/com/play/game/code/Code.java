package com.play.game.code;

public enum Code
{

    REQUEST_REFUSE("接入未授权"),

    ARGUMENT_REQUIRED("参数{0}不可为空"),

    ARGUMENT_SHORT("参数({0})长度不小于{1}"),

    ARGUMENT_LONG("参数({0})长度不大于{1}"),

    ARGUMENT_INVALID("参数({0})不合法"),

    ARGUMENT_CARDNO("参数({0})不是身份证号"),

    ARGUMENT_EMAIL("参数({0})不是电子邮箱"),

    ARGUMENT_JSON("参数({0})不是有效json"),

    ARGUMENT_MOBILE("参数({0})不是手机号"),

    ARGUMENT_URL("参数({0})不是有效的url"),

    ARGUMENT_NUMBER("参数({0})不是有效的数字"),

    ARGUMENT_FLOAT("参数({0})不是有效的小数"),

    REQUEST_INVALID("请求非法"),

    SERVER_ERROR("内部错误")
    ;

    private String parse;

    private String[] argNames;

    private Code(String parse, String... argNames) {
        this.parse = parse;
    }

    public String getReason() {
        return parse;
    }

    public String[] getArgNames() {
        return argNames;
    }
}
