package com.lr.api.common;

import java.io.Serializable;

/**
 * @author liurui
 * @date 2019/10/10 11:52
 */
public class BaseResponse<T> implements Serializable {
    private String code;
    private String msg;
    private T data;

    public static <T> BaseResponse<T> success(T data) {
        BaseResponse<T> resp = new BaseResponse();
        resp.setCode(ResponseCode.SUCCESS.getCode());
        resp.setMsg(ResponseCode.SUCCESS.getMsg());
        resp.setData(data);
        return resp;
    }

    public static <T> BaseResponse<T> fail(ResponseCode responseCode) {
        BaseResponse<T> resp = new BaseResponse();
        resp.setCode(responseCode.getCode());
        resp.setMsg(responseCode.getMsg());
        return resp;
    }

    public static <T> BaseResponse<T> fail(String code, String msg) {
        BaseResponse<T> resp = new BaseResponse();
        resp.setCode(code);
        resp.setMsg(msg);
        return resp;
    }

    public BaseResponse() {
        this.code = ResponseCode.SUCCESS.getCode();
        this.msg = ResponseCode.SUCCESS.getMsg();
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public T getData() {
        return this.data;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof BaseResponse)) {
            return false;
        } else {
            BaseResponse<?> other = (BaseResponse)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$code = this.getCode();
                    Object other$code = other.getCode();
                    if (this$code == null) {
                        if (other$code == null) {
                            break label47;
                        }
                    } else if (this$code.equals(other$code)) {
                        break label47;
                    }

                    return false;
                }

                Object this$msg = this.getMsg();
                Object other$msg = other.getMsg();
                if (this$msg == null) {
                    if (other$msg != null) {
                        return false;
                    }
                } else if (!this$msg.equals(other$msg)) {
                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof BaseResponse;
    }



    public String toString() {
        return "BaseResponse(code=" + this.getCode() + ", msg=" + this.getMsg() + ", data=" + this.getData() + ")";
    }
}
