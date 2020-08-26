package com.haobo.test;

import java.io.Serializable;

public class ResponseResult implements Serializable{
	   /*
     * 处理状态
     * 200成功  0失败
     */
    private int status;
    /*
     * 消息
     */
    private String msg;
    /*
     * 数据
     */
    private Object data;


    /**
     * 返回处理状态
     * @return 状态值 1表示成功;2\3\4
     */
    public int getStatus() {
        return status;
    }

    /**
     * 设置处理状态
     * @param status  状态值
     */
    public void setStatus(int status) {
        this.status = status;
    }
    @Override
	public String toString() {
		return "ResponseResult [status=" + status + ", msg=" + msg + ", data=" + data + "]";
	}

	public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
}
