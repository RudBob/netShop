package cn.edu.zzuli.util;

import java.util.HashMap;
import java.util.Map;

public class Msg {
    private boolean result;
    private String msg;
    private Map<String, Object> data;
    // 私有化构造器
    private Msg(){
        data = new HashMap<>();
    }
    // 提供两个工厂方法
    // 成功
    public static Msg success(){
        Msg msg = new Msg();
        msg.result = true;
        return msg;
    }
    // 失败
    public static Msg fail(){
        Msg msg = new Msg();
        msg.result = false;
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

    @Override
    public String toString() {
        return "Msg{" +
                "result=" + result +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
