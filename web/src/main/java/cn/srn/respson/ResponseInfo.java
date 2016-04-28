package cn.srn.respson;

import java.io.Serializable;

/**
 * Created by SRn on 2016/4/26.
 */
public class ResponseInfo implements Serializable{

    private int code;
    private String message;

    public ResponseInfo() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResponseInfo{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
