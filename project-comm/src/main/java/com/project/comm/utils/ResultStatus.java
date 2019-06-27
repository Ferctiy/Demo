package com.project.comm.utils;

public enum ResultStatus {

    Success(200, "Success", "处理成功"),

    NoData(204, "NoData", "无数据"),

    ParamError(400, "ParamError", "参数错误"),

    NoAuth(403, "NoAuth", "禁止访问"),

    NotFound(404, "NotFoundUrl", "路由出错"),

    Failed(417, "Failed", "处理失败"),

    UserNameOrPasswordError(418, "UserNameOrPasswordError", "登录名或密码错误"),

    UserForbidden(419, "UserForbidden", "用户被禁用"),

    Accepted(420, "Accepted", "已受理"),

    Error(500, "Error", "处理出错");

    /**
     * 数值
     */
    private int value;
    /**
     * 名称
     */
    private String name;
    /**
     * 信息
     */
    private String message;

    public static ResultStatus parse(int code) {
        if (code == Success.value)
            return Success;
        if (code == NoData.value)
            return NoData;
        if (code == ParamError.value)
            return ParamError;
        if (code == NoAuth.value)
            return NoAuth;
        if (code == NotFound.value)
            return NotFound;
        if (code == Failed.value)
            return Failed;
        if (code == UserNameOrPasswordError.value)
            return UserNameOrPasswordError;
        if (code == UserForbidden.value)
            return UserForbidden;
        if (code == Error.value)
            return Error;
        if (code == Accepted.value)
            return Accepted;
        return null;
    }

    ResultStatus(int value, String name, String message) {
        this.value = value;
        this.name = name;
        this.message = message;
    }

    /**
     * 取得数值
     *
     * @return
     */
    public int getValue() {
        return value;
    }

    /**
     * 取得名称
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 取得信息
     *
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     * 判断相等
     *
     * @param val
     * @return
     */
    public boolean equals(int val) {
        return this.value == val;
    }

    @Override
    public String toString() {
        return String.valueOf (value);
    }
}
