package cn.edu.zzuli.service.order.impl;

import cn.edu.zzuli.bean.UserOrder;
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
        return null;
    }

    @Override
    public void insertRecord(UserOrder userOrder) {
        userOrderMapper.insert(userOrder);
    }
}
