package cn.edu.zzuli.service.order.impl;

import cn.edu.zzuli.bean.Goods;
import cn.edu.zzuli.bean.OrderData;
import cn.edu.zzuli.mapper.OrderDataMapper;
import cn.edu.zzuli.service.goods.GoodsService;
import cn.edu.zzuli.service.order.OrderDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDataServiceImpl implements OrderDataService {
    @Autowired
    OrderDataMapper orderDataMapper;

    @Autowired
    GoodsService goodsService;

    @Override
    public List<OrderData> getOrderDataByOrderId(Integer orderId) {
        return orderDataMapper.selectByOrderId(orderId);
    }

    /**
     * 插入多条订单的详情
     *
     * @param orderDatas  多条订单详情数据
     * @param userOrderId 对应的订单号
     */
    @Override
    public void insertRecords(OrderData[] orderDatas, int userOrderId) {
        for (int i = 0; i < orderDatas.length; i++) {
            Goods goods = goodsService.selectGoodsById(orderDatas[i].getGoods().getGoodsId());
            double price = goods.getPrice() * orderDatas[i].getNum();
            orderDatas[i].setUoId(userOrderId);
            orderDatas[i].setGoodsPrice(price);
            orderDataMapper.insert(orderDatas[i]);
        }
    }
}
