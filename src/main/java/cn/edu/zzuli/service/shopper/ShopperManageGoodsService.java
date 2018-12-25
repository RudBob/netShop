package cn.edu.zzuli.service.shopper;

import cn.edu.zzuli.bean.Goods;

/**
 * @ClassName ShopperManageGoodsService
 * @Description TODO
 * @Author 任耀
 * @Date 2018/12/25 10:22
 * @Version 1.0
 */
public interface ShopperManageGoodsService {
    Goods putGoodsOnShelves(String goodsName, Double priceRefer, Double price);

    Goods putGoodsOutShelves(Integer goodsId);

    Goods updateGoodsInfo(Integer goodsId);
}
