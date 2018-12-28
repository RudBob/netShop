package cn.edu.zzuli.enums.order_enum;

/**
 * 订单的各种状态的枚举
 */
public enum OrderStatusEnum {
    NOT_PAY("未支付", 0),
    WAIT_DELIVER("等待发货", 1),
    WAIT_COLLECT("等待揽件", 2),
    DELIVERING("寄送中", 3),
    HAVE_SIGN("已签收", 4),
    WAIT_COMMENT("待评价", 5),
    OK("结束", -1);
    private String des;
    private Integer num;

    OrderStatusEnum(String des, Integer num) {
        this.des = des;
        this.num = num;
    }

    @Override
    public String toString() {
        return "OrderStatusEnum{" +
                "des='" + des + '\'' +
                ", num=" + num +
                '}';
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }}

