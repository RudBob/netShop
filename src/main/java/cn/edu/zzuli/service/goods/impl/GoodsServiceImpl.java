package cn.edu.zzuli.service.goods.impl;

import cn.edu.zzuli.bean.Goods;
import cn.edu.zzuli.mapper.GoodsMapper;
import cn.edu.zzuli.service.goods.GoodsService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
