package cn.edu.zzuli.service.order.impl;

import cn.edu.zzuli.bean.UserOrder;
import cn.edu.zzuli.enums.order_enum.OrderStatusEnum;
import cn.edu.zzuli.mapper.UserOrderMapper;
import cn.edu.zzuli.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    UserOrderMapper userOrderMapper;

    @Override
    public UserOrder getUserOrderById(Integer orderId) {

        return userOrderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public void insertRecord(UserOrder userOrder) {
        userOrderMapper.insert(userOrder);
    }

    /**
     * 得到用户最后一次的订单的id，给订单详情们当外键使用
     *
     * @param userId 用户编号
     * @return int 订单的编号
     */
    @Override
    public int getLastOrderId(Integer userId) {
        int res = userOrderMapper.selectLastOrderId(userId);
        return res;
    }

    /**
     * 用户支付成功，改变用户订单的状态
     *
     * @param userOrder 用户订货
     */
    @Override
    public void payOrderSuccess(UserOrder userOrder) {
        userOrder.setOrderStatus(OrderStatusEnum.WAIT_DELIVER);
        userOrderMapper.updateByPrimaryKey(userOrder);
    }
}
