package cn.edu.zzuli.util.userDataSetting;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName UserRoleEnum
 * @Description 用户角色的枚举
 * @Author 任耀
 * @Date 2018/12/23 12:33
 * @Version 1.0
 */
public enum UserRoleEnum {

    CONSUMER("顾客", 0), SHOPPER("店家", 1);
    private String stateName;

    private Integer stateNum;
    /**
     * 存储键值对映射的Map
     */
    private static Map<Integer, UserRoleEnum> valueMap = new HashMap<>();

    static {
        for (UserRoleEnum item : UserRoleEnum.values()) {
            valueMap.put(item.stateNum, item);
        }
    }

    UserRoleEnum() {
    }

    UserRoleEnum(String stateName, Integer stateNum) {
        this.stateName = stateName;
        this.stateNum = stateNum;
    }

    /**
     * 将传入的stateNum转为int
     *
     * @param stateNum
     * @return
     */
    public static UserRoleEnum getStateByNum(int stateNum) {
        UserRoleEnum res = valueMap.get(stateNum);
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

    public static Map<Integer, UserRoleEnum> getValueMap() {
        return valueMap;
    }

    public static void setValueMap(Map<Integer, UserRoleEnum> valueMap) {
        UserRoleEnum.valueMap = valueMap;
    }

    @Override
    public String toString() {
        return "UserRoleEnum{" +
                "stateName='" + stateName + '\'' +
                ", stateNum=" + stateNum +
                '}';
    }

}