package cn.edu.zzuli.enums.user_enum;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName UserStateEnum
 * @Description 用户角色
 * @Author 任耀
 * @Date 2018/12/23 12:32
 * @Version 1.0
 */
public enum UserStateEnum {
    /**
     * 未激活：NO_CONFIRM
     * 正常: NORMAL
     */
    NO_CONFIRM("未激活", 0), NORMAL("正常", 1);
    private String stateName;

    private Integer stateNum;
    /**
     * 存储键值对映射的Map
     */
    private static Map<Integer, UserStateEnum> valueMap = new HashMap<>();

    static {
        for (UserStateEnum item : UserStateEnum.values()) {
            valueMap.put(item.stateNum, item);
        }
    }

    UserStateEnum() {
    }

    UserStateEnum(String stateName, Integer stateNum) {
        this.stateName = stateName;
        this.stateNum = stateNum;
    }

    /**
     * 将传入的stateNum转为int
     * @param stateNum
     * @return
     */
    public static UserStateEnum getStateByNum(int stateNum) {
        UserStateEnum res = valueMap.get(stateNum);
        if (res == null) {
            throw new IllegalArgumentException("No element matches " + stateNum);
        }
        return res;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Integer getStateNum() {
        return stateNum;
    }

    public void setStateNum(Integer stateNum) {
        this.stateNum = stateNum;
    }

    @Override
    public String toString() {
        return "stateName='" + stateName + '\'' +
                ", stateNum=" + stateNum;
    }}
