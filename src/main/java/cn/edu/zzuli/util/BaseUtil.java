package cn.edu.zzuli.util;

import java.util.Map;

/**
 * @ClassName BaseUtil
 * @Description 最最最常用的工具类
 * @Author 任耀
 * @Date 2018/12/24 18:48
 * @Version 1.0
 */
public class BaseUtil {
    /**
     * 将条件封装至Map中，以便于能够在.xml中很好的调用
     *
     * @param info Map容器
     * @param objs 待封装内容
     */
    public static void initInfo(Map<String, Object> info, Object... objs) {
        // 清空info中的内容
        info.clear();
        // 如果待封装内容不是以String, Object的成双成对的出现，那么直接返回。
        if (objs.length % 2 != 0) {
            return;
        }
        // 依次放入map容器
        for (int i = 0; i < objs.length; i++) {
            info.put((String) objs[i], objs[++i]);
        }
    }

}
