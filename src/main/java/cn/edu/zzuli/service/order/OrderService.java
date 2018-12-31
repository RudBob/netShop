package cn.edu.zzuli.service.order;

import cn.edu.zzuli.bean.UserOrder;

public interface OrderService {
    UserOrder getUserOrderById(Integer orderId);

    void insertRecord(UserOrder userOrder);

}
