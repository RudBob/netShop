package cn.edu.zzuli.service.consumer;

import cn.edu.zzuli.bean.UserOrder;

public interface ConsumerGoodsService {
    UserOrder buyGoods(Integer goodsId, Integer goodsNum);

    int collectGoods(Integer goodsId);
}
