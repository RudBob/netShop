package cn.edu.zzuli.service.shopper.impl;

import cn.edu.zzuli.bean.Goods;
import cn.edu.zzuli.bean.Shop;
import cn.edu.zzuli.bean.User;
import cn.edu.zzuli.enums.goods_enum.GoodsEnum;
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

    /**
     * 上架商品。
     *
     * @param goodsName  商品名称
     * @param priceRefer 参考价格
     * @param price      价格
     * @return
     */
    @Override
    public Goods putGoodsOnShelves(String goodsName, Double priceRefer, Double price, Integer goodsStock) {
        User user = SessionUtil.getUserFromSession();
        Shop shop = shopService.getShopByShopperId(user.getUserId());
        //生成一个初始化的商品
        Goods goods = Goods.goodsFactory(goodsName, priceRefer, price, shop.getShId(), goodsStock);
        // 将商品插入商品数据库
        goodsMapper.insert(goods);
        return goods;
    }

    /**
     * 下架商品
     *
     * @param goodsId 商品id
     * @return 返回修改后的商品
     */
    @Override
    public Goods putGoodsOutShelves(Integer goodsId) {
        // 从数据库中获取到对应的商品
        Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
        // 更新状态为售完。
        goods.setGoodsEnum(GoodsEnum.TEMP_OUT);
        goodsMapper.updateByPrimaryKey(goods);
        return goods;
    }

    /**
     * 更新商品信息
     *
     * @param goodsId    商品id
     * @param goodsName  商品名
     * @param price      价格
     * @param priceRefer 参考价格
     * @param goodsStock 商品库存
     * @return 将修改后的商品返回。
     */
    @Override
    public Goods updateGoodsInfo(Integer goodsId, String goodsName, Double price, Double priceRefer, Integer goodsStock) {
        Goods goods = new Goods(goodsId, goodsName, price, priceRefer, goodsStock);
        goodsMapper.updateByPrimaryKeySelective(goods);
        // 查询数据库，将结果返回
        goods = goodsMapper.selectByPrimaryKey(goodsId);
        return goods;
    }
}
