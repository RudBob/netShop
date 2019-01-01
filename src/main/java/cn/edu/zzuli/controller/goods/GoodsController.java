package cn.edu.zzuli.controller.goods;

import cn.edu.zzuli.bean.Goods;
import cn.edu.zzuli.service.goods.GoodsService;
import cn.edu.zzuli.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName GoodsController
 * @Description 商品的操作
 * @Author 任耀
 * @Date 2018/12/25 8:54
 * @Version 1.0
 */
@Api(description = "商品的一些操作")
@RestController
@RequestMapping(value = "/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    /**
     * 展示一个店的所有商品
     *
     * @param shopId 商店的id
     */
    @RequestMapping(value = "showGoods", method = RequestMethod.GET)
    public Msg showGoods(@RequestParam(value = "shopId") Integer shopId) {
        List<Goods> goodsList = goodsService.getGoodsInShop(shopId);
        return returnGoods(goodsList);
    }

    /**
     * 用户条件查询商品,默认排序：综合排序
     */
    @RequestMapping(value = "selectGoodsByInfo", method = RequestMethod.GET)
    public Msg showGoodsByInfo(@RequestParam(value = "info") String info) {
        List<Goods> goodsList = goodsService.showGoodsByInfo(info, GoodsService.NO_ORDER);
        return returnGoods(goodsList);
    }

    /**
     * 用户条件查询商品,默认排序：时间排序
     */
    @RequestMapping(value = "showGoodsByInfoOrderByTime", method = RequestMethod.GET)
    public Msg showGoodsByInfoOrderByTime(@RequestParam(value = "info") String info) {
        List<Goods> goodsList = goodsService.showGoodsByInfo(info, GoodsService.ORDER_BY_TIME);
        return returnGoods(goodsList);
    }


    /**
     * 用户条件查询商品,默认排序：销量排序
     */
    @RequestMapping(value = "showGoodsByInfoOrderBySales", method = RequestMethod.GET)
    public Msg showGoodsByInfoOrderBySales(@RequestParam(value = "info") String info) {
        List<Goods> goodsList = goodsService.showGoodsByInfo(info, GoodsService.ORDER_BY_SALES);
        return returnGoods(goodsList);
    }

    /**
     * 用户条件查询商品,默认排序：价格排序
     */
    @RequestMapping(value = "showGoodsByInfoOrderByPrice", method = RequestMethod.GET)
    public Msg showGoodsByInfoOrderByPrice(@RequestParam(value = "info") String info) {
        List<Goods> goodsList = goodsService.showGoodsByInfo(info, GoodsService.ORDER_BY_PRICE);
        return returnGoods(goodsList);
    }

    /**
     * 返回值格式完全相同，所以进行了提取
     *
     * @param goodsList 商品列表
     */
    private Msg returnGoods(List<Goods> goodsList) {
        if (goodsList != null && goodsList.size() != 0) {
            return Msg.success().addResData("goods", goodsList);
        }
        return Msg.fail();
    }
}
