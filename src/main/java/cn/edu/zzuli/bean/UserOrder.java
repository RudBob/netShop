package cn.edu.zzuli.bean;

import cn.edu.zzuli.enums.order_enum.OrderStatusEnum;

import java.util.Date;
import java.util.List;

/**
 * 一个商品订单
 */
public class UserOrder {
    private Integer uoId;
    /**
     * 用户编号
     */
    private Integer userId;
    /**
     * 订单日期
     */
    private Date orderDatetime;
    /**
     * 订单地址
     */
    private String orderAddr;
    /**
     * 收货名
     */
    private String orderUsername;

    /**
     * 订单中的数据
     */
    private List<OrderData> orderDataList;

    /**
     * 订单状态
     */
    private OrderStatusEnum oderStatus;

    public UserOrder() {

    }

    @Override
    public String toString() {
        return "UserOrder{" +
                "uoId=" + uoId +
                ", userId=" + userId +
                ", orderDatetime=" + orderDatetime +
                ", orderAddr='" + orderAddr + '\'' +
                ", orderUsername='" + orderUsername + '\'' +
                ", orderDataList=" + orderDataList +
                ", oderStatus=" + oderStatus +
                '}';
    }

    public Integer getUoId() {
        return uoId;
    }

    public void setUoId(Integer uoId) {
        this.uoId = uoId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getOrderDatetime() {
        return orderDatetime;
    }

    public void setOrderDatetime(Date orderDatetime) {
        this.orderDatetime = orderDatetime;
    }

    public String getOrderAddr() {
        return orderAddr;
    }

    public void setOrderAddr(String orderAddr) {
        this.orderAddr = orderAddr == null ? null : orderAddr.trim();
    }

    public String getOrderUsername() {
        return orderUsername;
    }

    public void setOrderUsername(String orderUsername) {
        this.orderUsername = orderUsername == null ? null : orderUsername.trim();
    }

    public List<OrderData> getOrderDataList() {
        return orderDataList;
    }

    public void setOrderDataList(List<OrderData> orderDataList) {
        this.orderDataList = orderDataList;
    }

    public OrderStatusEnum getOderStatus() {
        return oderStatus;
    }

    public void setOderStatus(OrderStatusEnum oderStatus) {
        this.oderStatus = oderStatus;
    }
}