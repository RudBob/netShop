package cn.edu.zzuli.bean;

import cn.edu.zzuli.enums.order_enum.OrderStatusEnum;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户订单
 */
public class UserOrder {
    private Integer uoId;

    private Integer userId;

    private LocalDateTime orderDatetime;

    private String receiverAddr;

    private String receiverName;

    private String receiverTel;

    private OrderStatusEnum orderStatus;

    /**
     * 订单详情
     */
    private List<OrderData> orderDataList;



    public UserOrder() {
    }

    public static UserOrder userOrderFactory(Integer userId, UserAddr userAddr) {
        UserOrder userOrder = new UserOrder();
        userOrder.setOrderDatetime(LocalDateTime.now());
        userOrder.setOrderStatus(OrderStatusEnum.NOT_PAY);
        userOrder.setUserId(userId);
        userOrder.setReceiverAddr(userAddr.getAddName());
        userOrder.setReceiverName(userAddr.getReceiverName());
        userOrder.setReceiverTel(userAddr.getReceiverTel());

        return userOrder;
    }

    @Override
    public String toString() {
        return "UserOrder{" +
                "uoId=" + uoId +
                ", userId=" + userId +
                ", orderDatetime=" + orderDatetime +
                ", receiverAddr='" + receiverAddr + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", receiverTel='" + receiverTel + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderDataList=" + orderDataList +
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

    public LocalDateTime getOrderDatetime() {
        return orderDatetime;
    }

    public void setOrderDatetime(LocalDateTime orderDatetime) {
        this.orderDatetime = orderDatetime;
    }

    public String getReceiverAddr() {
        return receiverAddr;
    }

    public void setReceiverAddr(String receiverAddr) {
        this.receiverAddr = receiverAddr == null ? null : receiverAddr.trim();
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName == null ? null : receiverName.trim();
    }

    public String getReceiverTel() {
        return receiverTel;
    }

    public void setReceiverTel(String receiverTel) {
        this.receiverTel = receiverTel == null ? null : receiverTel.trim();
    }

    public OrderStatusEnum getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderData> getOrderDataList() {
        return this.orderDataList;
    }

    public void setOrderDataList(List<OrderData> orderDataList) {
        this.orderDataList = orderDataList;
    }
}