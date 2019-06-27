package com.project.comm.utils;

/**
 * API Response
 */
public class RestResult<T> {

    /**
     * 状态
     */
    private int status;
    /**
     * 信息
     */
    private String message;

    /**
     * 数据模型
     */
    private Object data;

    public RestResult() {
    }

    public RestResult(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public RestResult(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
