package cn.edu.zzuli.service.consumer.impl;

import cn.edu.zzuli.bean.UserOrder;
import cn.edu.zzuli.mapper.UserOrderMapper;
import cn.edu.zzuli.service.consumer.ConsumerGoodsService;
import cn.edu.zzuli.service.consumer.ConsumerService;
import cn.edu.zzuli.service.goods.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;

public class ConsumerGoodsServiceImpl implements ConsumerGoodsService {
    @Autowired
    GoodsService goodsService;
    @Autowired
    ConsumerService userService;
    @Autowired
    UserOrderMapper userOrderMapper;

    /**
     * 用户购买一个商品
     *
     * @param goodsId  商品id
     * @param goodsNum 购买个数
     * @return
     */
    @Override
    public UserOrder buyGoods(Integer goodsId, Integer goodsNum) {
        // 检查余额

        // 支付金额

        // 生成订单

        // 返回订单
        return null;
    }

    /**
     * 未来实现
     *
     * @param goodsId
     * @return
     */
    @Override
    public int collectGoods(Integer goodsId) {

        return 0;
    }
}
