package cn.edu.zzuli.enums.goods_enum;

import java.util.HashMap;
import java.util.Map;

public enum GoodsEnum {
    NORMAL("正常", 1), SOLD_OUT("售完", 2), FORBID("违规", 0),
    TEMP_OUT("店家下架", 3);
    private String statusName;
    private Integer statusNum;

    GoodsEnum(String name, Integer num) {
        statusName = name;
        statusNum = num;
    }

    /**
     * 存储键值对映射的Map
     */
    private static Map<Integer, GoodsEnum> valueMap = new HashMap<>();

    static {
        for (GoodsEnum item : GoodsEnum.values()) {
            valueMap.put(item.statusNum, item);
        }
    }

    public GoodsEnum getGoodsEnumByNum(Integer num) {
        GoodsEnum res = valueMap.get(num);
        if (res == null) {
            throw new IllegalArgumentException("No element matches " + num);
        }
        return res;
    }

    public Integer getStatusNum() {
        return statusNum;
    }

    public void setStatusNum(Integer statusNum) {
        this.statusNum = statusNum;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return "GoodsEnum{" +
                "statusName='" + statusName + '\'' +
                ", statusNum=" + statusNum +
                '}';
    }
}
