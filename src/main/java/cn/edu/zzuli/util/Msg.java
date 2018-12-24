package cn.edu.zzuli.util;

import java.util.HashMap;
import java.util.Map;

public class Msg {
    private boolean success;
    private String msg;
    private Map<String, Object> data;
    // 私有化构造器
    private Msg(){
    }
    // 提供两个工厂方法
    // 成功
    public static Msg success(){
        Msg msg = new Msg();
        msg.success = true;
        msg.data = new HashMap<String, Object>();
        return msg;
    }
    // 失败
    public static Msg fail(){
        Msg msg = new Msg();
        msg.success = false;
        msg.data = new HashMap<String, Object>();
        return msg;
    }
    public Msg setMsg(String msg){
        this.msg = msg;
        return this;
    }
    public Msg addResData(String resName, Object resData){
        this.data.put(resName,resData);
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "success=" + success +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
