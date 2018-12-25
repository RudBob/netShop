package cn.edu.zzuli.controller.goods;

import cn.edu.zzuli.bean.Goods;
import cn.edu.zzuli.service.goods.GoodsService;
import cn.edu.zzuli.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ClassName GoodsController
 * @Description 商品的操作
 * @Author 任耀
 * @Date 2018/12/25 8:54
 * @Version 1.0
 */
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    /**
     * 展示一个店的所有商品
     *
     * @param shopId
     * @return
     */
    @RequestMapping(value = "showGoods", method = RequestMethod.GET)
    public Msg showGoods(@RequestParam(value = "shopId") Integer shopId) {
        List<Goods> goodsList = goodsService.getGoodsInShop(shopId);
        if (goodsList.size() != 0) {
            return Msg.success().addResData("goods", goodsList);
        }
        // 这家商店没有上架任何商品
        return Msg.fail();
    }
}
