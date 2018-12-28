package cn.edu.zzuli.service.shopper;

import cn.edu.zzuli.bean.Goods;

/**
 * @ClassName ShopperManageGoodsService
 * @Description 店家管理商品的相关操作...
 * @Author 任耀
 * @Date 2018/12/25 10:22
 * @Version 1.0
 */
public interface ShopperManageGoodsService {
    Goods putGoodsOnShelves(String goodsName, Double priceRefer, Double price,Integer goodsStock);

    Goods putGoodsOutShelves(Integer goodsId);

    Goods updateGoodsInfo(Integer id, String goodsName, Double price, Double priceRefer, Integer goodsId);
}
