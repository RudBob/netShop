package cn.edu.zzuli.service.goods;

import cn.edu.zzuli.bean.Goods;

import java.util.List;

/**
 * @ClassName GoodsSortService
 * @Description 商品排序
 * @Author 任耀
 * @Date 2018/12/25 8:48
 * @Version 1.0
 */
public interface GoodsSortService {
    /**
     * 商品按时间排序
     * @param goods
     * @return
     */
    List<Goods> goodsOrderByTime(List<Goods> goods);

    /**
     * 商品按销量排序
     * @param goods
     * @return
     */
    List<Goods> goodsOrderBySales(List<Goods> goods);

    /**
     * 商品按价格排序
     * @param goods
     * @return
     */
    List<Goods> goodsOrderByPrice(List<Goods> goods);

}
