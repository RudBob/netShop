package cn.edu.zzuli.service.goods.impl;

import cn.edu.zzuli.bean.Goods;
import cn.edu.zzuli.mapper.GoodsMapper;
import cn.edu.zzuli.service.goods.GoodsService;
import cn.edu.zzuli.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName GoodsService
 * @Description 商品的一些简单操作
 * @Author 任耀
 * @Date 2018/12/25 8:47
 * @Version 1.0
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;


    @Override
    public List<Goods> getGoodsInShop(Integer shopId) {
        List<Goods> goods = goodsMapper.selectGoodsByShopId(shopId);
        return goods;
    }

    @Override
    public List<Goods> showGoodsByInfo(String information, int orderBy) {
        Map<String, Object> info = new HashMap<String, Object>();
        info.put("information", information);
        if (GoodsService.ORDER_BY_TIME == orderBy) {
            info.put("orderByTime", new Object());
        } else if (GoodsService.ORDER_BY_SALES == orderBy) {
            info.put("orderBySales", new Object());
        } else if (GoodsService.ORDER_BY_PRICE == orderBy) {
            info.put("orderByPrice", new Object());
        }
        List<Goods> goodsList = goodsMapper.selectGoodsByInfo(info);
        return goodsList;
    }

    /**
     * 通过id 得到商品
     *
     * @param goodsId
     * @return
     */
    @Override
    public Goods selectGoodsById(Integer goodsId) {
        Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
        return goods;
    }
}
