package cn.edu.zzuli.service.consumer;

import cn.edu.zzuli.bean.OrderData;
import cn.edu.zzuli.bean.UserOrder;

public interface ConsumerGoodsService {
    UserOrder createOrder(OrderData[] orderDatas, Integer addrId);

    UserOrder payOrder(Integer orderId, String payPwd);

    int collectGoods(Integer goodsId);

}
