package cn.edu.zzuli.service.shopper.impl;

import cn.edu.zzuli.bean.UserOrder;
import cn.edu.zzuli.enums.order_enum.OrderStatusEnum;
import cn.edu.zzuli.mapper.OrderDataMapper;
import cn.edu.zzuli.mapper.UserOrderMapper;
import cn.edu.zzuli.service.shopper.ShopperOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopperOrderServiceImpl implements ShopperOrderService {
    @Autowired
    UserOrderMapper userOrderMapper;
    @Autowired
    OrderDataMapper orderDataMapper;

    @Override
    public int updateOrderInfo(UserOrder userOrder) {
        int resLine = userOrderMapper.updateByPrimaryKeySelective(userOrder);
        return resLine;
    }

    @Override
    public int waitDeliver(Integer orderId) {
        UserOrder userOrder = userOrderMapper.selectByPrimaryKey(orderId);
        // 将状态更新为等待揽件
        userOrder.setOrderStatus(OrderStatusEnum.WAIT_COLLECT);
        return updateOrderInfo(userOrder);
    }
}
