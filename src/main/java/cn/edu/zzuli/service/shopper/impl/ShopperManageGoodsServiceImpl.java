package cn.edu.zzuli.service.shopper.impl;

import cn.edu.zzuli.bean.Goods;
import cn.edu.zzuli.bean.Shop;
import cn.edu.zzuli.bean.User;
import cn.edu.zzuli.mapper.GoodsMapper;
import cn.edu.zzuli.service.shop.ShopService;
import cn.edu.zzuli.service.shopper.ShopperManageGoodsService;
import cn.edu.zzuli.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName ShopperManageGoodsServiceImpl
 * @Description 店主对自家商店的商品的管理
 * @Author 任耀
 * @Date 2018/12/25 10:22
 * @Version 1.0
 */
@Service
public class ShopperManageGoodsServiceImpl implements ShopperManageGoodsService {
    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    ShopService shopService;

    @Override
    public Goods putGoodsOnShelves(String goodsName, Double priceRefer, Double price) {
        User user = SessionUtil.getUserFromSession();
        Shop shop = shopService.getShopByShopperId(user.getUserId());
        Goods goods = Goods.goodsFactory(goodsName, priceRefer, price, shop.getShId());

        return null;
    }

    @Override
    public Goods putGoodsOutShelves(Integer goodsId) {
        return null;
    }

    @Override
    public Goods updateGoodsInfo(Integer goodsId) {
        return null;
    }
}
