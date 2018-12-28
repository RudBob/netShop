package cn.edu.zzuli.service.consumer;

import cn.edu.zzuli.bean.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    /**
     * 展示用户的购物车.
     *
     * @return 用户购物车中的内容
     */
    List<ShoppingCart> showCart();

    /**
     * 更新购物车中某个商品的数量
     *
     * @return 更新购物车中的数据的行数
     */
    int updateGoodsNum(Integer cartId, Integer goodsNum);

    /**
     * 删除购物车中某个商品
     *
     * @param cartId 待删除商品的id
     * @return
     */
    int deleteGoodsInCart(Integer cartId);

    /**
     * 新增某个商品进入购物车
     *
     * @param goodsId 待删除商品的id
     * @return
     */
    int addGoodsIntoCart(Integer goodsId);
}
