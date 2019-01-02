package cn.edu.zzuli.service.shopper;

import cn.edu.zzuli.bean.UserOrder;

public interface ShopperOrderService {
    int updateOrderInfo(UserOrder userOrder);

    int waitDeliver(Integer orderId);
}
