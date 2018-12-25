package cn.edu.zzuli.service.goods;

import cn.edu.zzuli.bean.Goods;

import java.util.List;

/**
 * @ClassName GoodsService
 * @Description 商品的简单操作
 * @Author 任耀
 * @Date 2018/12/25 8:47
 * @Version 1.0
 */
public interface GoodsService {
    /**
     * 得到这家商店的商品
     * @param shopId
     * @return
     */
    List<Goods> getGoodsInShop(Integer shopId);

}
