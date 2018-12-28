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
     *
     * @param shopId
     * @return
     */
    List<Goods> getGoodsInShop(Integer shopId);

    /**
     * 默认排序
     */
    int NO_ORDER = 0;
    /**
     * 通过销量排序
     */
    int ORDER_BY_SALES = 1;
    /**
     * 通过价格
     */
    int ORDER_BY_PRICE = 2;
    /**
     * 通过时间
     */
    int ORDER_BY_TIME = 3;

    /**
     * @param information 通过条件查询商品
     * @param order       排序条件
     * @return
     */
    List<Goods> showGoodsByInfo(String information, int order);

    Goods selectGoodsById(Integer goodsId);

}
