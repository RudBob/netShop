package cn.edu.zzuli.service.goods.impl;

import cn.edu.zzuli.bean.Goods;
import cn.edu.zzuli.service.goods.GoodsSortService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName GoodsSortServiceImpl
 * @Description 商品排序接口的实现
 * @Author 任耀
 * @Date 2018/12/25 8:48
 * @Version 1.0
 */
public class GoodsSortServiceImpl implements GoodsSortService {
    /**
     * 说是按照时间，其实还是按照id
     *
     * @param goods 待比较的商品
     * @return  完成排序的商品
     */
    @Override
    public List<Goods> goodsOrderByTime(List<Goods> goods) {
        Collections.sort(goods, new OrderByTimeComparator());
        return goods;
    }
    /**
     * 按照时间的比较器类
     */
    class OrderByTimeComparator implements Comparator<Goods> {
        @Override
        public int compare(Goods g1, Goods g2) {
            return Integer.compare(g1.getGoodsId(), g2.getGoodsId());
        }
    }

    /**
     * 按照销量进行商品排序
     *
     * @param goods 待比较的商品
     * @return  完成排序的商品
     */
    @Override
    public List<Goods> goodsOrderBySales(List<Goods> goods) {
        Collections.sort(goods, new OrderBySalesComparator());
        return goods;
    }
    /**
     * 按照销量的比较器类
     */
    class OrderBySalesComparator implements Comparator<Goods> {
        @Override
        public int compare(Goods g1, Goods g2) {
            return Integer.compare(g1.getGoodsId(), g2.getGoodsId());
        }
    }

    /**
     * 按照销量进行商品排序
     *
     * @param goods 待比较的商品
     * @return  完成排序的商品
     */
    @Override
    public List<Goods> goodsOrderByPrice(List<Goods> goods) {
        Collections.sort(goods, new OrderByPriceComparator());
        return goods;
    }

    /**
     * 按照价格排序的比较器类
     */
    class OrderByPriceComparator implements Comparator<Goods> {
        @Override
        public int compare(Goods g1, Goods g2) {
            return Double.compare(g1.getPrice(), g2.getPrice());
        }
    }


}
