package cn.edu.zzuli.controller.consumer;

import cn.edu.zzuli.bean.OrderData;
import cn.edu.zzuli.bean.UserOrder;
import cn.edu.zzuli.service.consumer.ConsumerGoodsService;
import cn.edu.zzuli.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 顾客对商品的各种操作
 */
@Api(description = "顾客对商品的操作")
@RestController
@RequestMapping(value = "consumerGoods")
public class ConsumerGoodsController {
    @Autowired
    ConsumerGoodsService consumerGoodsService;

    /**
     * 生成一个订单
     *
     * @param orderDatas 待生成的订单详情
     * @return
     */
    @RequestMapping(value = "createOrder", method = RequestMethod.POST)
    public Msg createOrder(@RequestBody OrderData[] orderDatas,
                           @RequestParam(value = "addrId") Integer addrId) {
        UserOrder order = consumerGoodsService.createOrder(orderDatas, addrId);
        return returnOrder(order);
    }

    /**
     * 支付某个订单
     *
     * @param orderId 订单id
     * @return
     */
    @RequestMapping(value = "payOrder", method = RequestMethod.POST)
    public Msg payOrder(@RequestParam(value = "orderId") Integer orderId,
                        @RequestParam(value = "payPwd") String payPwd) {
        UserOrder order = consumerGoodsService.payOrder(orderId, payPwd);
        return returnOrder(order);
    }

    /**
     * 返回题方法
     *
     * @param order 一个订单
     * @return 封装至Msg
     */
    private Msg returnOrder(@RequestBody UserOrder order) {
        if (order != null && order.getOrderDataList() != null && order.getOrderDataList().size() != 0) {
            return Msg.success().addResData("order", order);
        }
        return Msg.fail();
    }

    /**
     * 收藏商品
     *
     * @param goodsId 商品id
     * @return
     */
    @RequestMapping(value = "collectGoods", method = RequestMethod.POST)
    public Msg collectGoods(@RequestParam(value = "goodsId") Integer goodsId) {
        int lineNum = consumerGoodsService.collectGoods(goodsId);
        if (lineNum != 0) {
            return Msg.success();
        }
        return Msg.fail();
    }
}