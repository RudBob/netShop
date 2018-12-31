package cn.edu.zzuli.controller.shopper;

import cn.edu.zzuli.bean.Goods;
import cn.edu.zzuli.service.shopper.ShopperManageGoodsService;
import cn.edu.zzuli.util.Msg;
import io.swagger.annotations.Api;
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
@Api(description = "店家对自家商品的操作")
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
                                 @RequestParam(value = "price") Double price,
                                 @RequestParam(value = "priceRefer", required = false) Double priceRefer,
                                 @RequestParam(value = "goodsStock", defaultValue = "0", required = false) Integer goodsStock) {
        Goods goods = shopperManageGoodsService.putGoodsOnShelves(goodsName, priceRefer, price, goodsStock);
        if (goods != null) {
            return Msg.success().addResData("goods", goods);
        }
        return Msg.fail();
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
        if (goods != null) {
            return Msg.success().addResData("goods", goods);
        }
        return Msg.fail();
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
                               @RequestParam(value = "goodsName", required = false) String goodsName,
                               @RequestParam(value = "price", required = false) Double price,
                               @RequestParam(value = "priceRefer", required = false) Double priceRefer,
                               @RequestParam(value = "goodsStock", required = false) Integer goodsStock) {
        Goods goods = shopperManageGoodsService.updateGoodsInfo(goodsId,goodsName,price,priceRefer,goodsStock);
        if (goods != null) {
            return Msg.success().addResData("goods", goods);
        }
        return Msg.fail();
    }
}
