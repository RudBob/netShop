package cn.edu.zzuli.controller.shopper;

import cn.edu.zzuli.bean.Goods;
import cn.edu.zzuli.service.shopper.ShopperManageGoodsService;
import cn.edu.zzuli.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ShopGoodsController
 * @Description 店家对自家商品的增删改查操作
 * @Author 任耀
 * @Date 2018/12/25 8:58
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/shopperManageGoods")
public class ShopperManageGoodsController {
    @Autowired
    ShopperManageGoodsService shopperManageGoodsService;

    /**
     * 上架商品
     *
     * @param goodsName  商品名称
     * @param priceRefer 参考价格
     * @param price      商品价格
     * @return
     */
    @RequestMapping(value = "putGoodsOnShelves", method = RequestMethod.POST)
    public Msg putGoodsOnShelves(@RequestParam(value = "goodsName") String goodsName,
                                 @RequestParam(value = "priceRefer") Double priceRefer,
                                 @RequestParam(value = "price") Double price) {
        Goods goods = shopperManageGoodsService.putGoodsOnShelves(goodsName,priceRefer,price);
        return Msg.success();
    }

    /**
     * 下架商品
     *
     * @param goodsId 待下架商品的id
     * @return
     */
    @RequestMapping(value = "putGoodsOutShelves", method = RequestMethod.POST)
    public Msg putGoodsOutShelves(@RequestParam(value = "goodsId") Integer goodsId) {
        Goods goods = shopperManageGoodsService.putGoodsOutShelves(goodsId);
        return Msg.success();
    }

    /**
     * 更改商品信息
     *
     * @param goodsName  商品名称
     * @param priceRefer 参考价格
     * @param price      商品价格
     * @return
     */
    @RequestMapping(value = "updateGoodsInfo", method = RequestMethod.POST)
    public Msg updateGoodsInfo(@RequestParam(value = "goodsId") Integer goodsId,
                               @RequestParam(value = "goodsName") String goodsName,
                               @RequestParam(value = "priceRefer") Double priceRefer,
                               @RequestParam(value = "price") Double price) {
        Goods goods = shopperManageGoodsService.updateGoodsInfo(goodsId);
        return Msg.success();
    }

}
