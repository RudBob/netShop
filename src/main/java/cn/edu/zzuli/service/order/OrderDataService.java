package cn.edu.zzuli.service.order;

import cn.edu.zzuli.bean.OrderData;

import java.util.List;

public interface OrderDataService {
    List<OrderData> getOrderDataByOrderId(Integer orderId);
}
