package cn.edu.zzuli.controller.consumer;

import cn.edu.zzuli.bean.UserOrder;
import cn.edu.zzuli.service.consumer.ConsumerGoodsService;
import cn.edu.zzuli.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 顾客对商品的各种操作
 */
@RestController
@RequestMapping(value = "consumerGoods")
public class ConsumerGoodsController {
    @Autowired
    ConsumerGoodsService consumerGoodsService;

    @RequestMapping(value = "buyGoods", method = RequestMethod.POST)
    public Msg buyGoods(@RequestParam(value = "goodsId") Integer goodsId,
                        @RequestParam(value = "goodsNum") Integer goodsNum) {
        UserOrder order = consumerGoodsService.buyGoods(goodsId, goodsNum);
        if (order != null && order.getOrderDataList() != null && order.getOrderDataList().size() != 0) {
            return Msg.success().addResData("order", order);
        }
        return Msg.fail();
    }


    @RequestMapping(value = "collectGoods", method = RequestMethod.POST)
    public Msg collectGoods(@RequestParam(value = "goodsId") Integer goodsId) {
        int lineNum = consumerGoodsService.collectGoods(goodsId);
        if (lineNum != 0) {
            return Msg.success();
        }
        return Msg.fail();
    }

}
