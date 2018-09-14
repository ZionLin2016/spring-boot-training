package cn.lsd.angular.model;

import java.io.Serializable;

/**
 * @Author: LSD
 * @Date: 2018/9/13
 */
public class ResultModel<T> implements Serializable {

    private static final long serialVersionUID = 4307899221841262601L;

    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体内容. */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
