package cn.edu.zzuli.service.order.impl;

import cn.edu.zzuli.bean.OrderData;
import cn.edu.zzuli.service.order.OrderDataService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDataServiceImpl implements OrderDataService {
    @Override
    public List<OrderData> getOrderDataByOrderId(Integer orderId) {
        return null;
    }
}
