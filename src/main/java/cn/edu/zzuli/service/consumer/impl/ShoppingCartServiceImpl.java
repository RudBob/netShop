package cn.edu.zzuli.service.consumer.impl;

import cn.edu.zzuli.bean.Goods;
import cn.edu.zzuli.bean.ShoppingCart;
import cn.edu.zzuli.bean.User;
import cn.edu.zzuli.mapper.ShoppingCartMapper;
import cn.edu.zzuli.service.consumer.ShoppingCartService;
import cn.edu.zzuli.service.goods.GoodsService;
import cn.edu.zzuli.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户对购物车的操作
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    ShoppingCartMapper shoppingCartMapper;

    @Autowired
    GoodsService goodsService;

    /**
     * 得到用户的购物车的内容
     *
     * @return 用户和他的购物车的内容
     */
    @Override
    public List<ShoppingCart> showCart() {
        User user = SessionUtil.getUserFromSession();
        Map<String, Object> info = new HashMap<>();
        info.put("userId", user.getUserId());
        List<ShoppingCart> shoppingCart = shoppingCartMapper.selectCartByInfoCascade(info);
        return shoppingCart;
    }

    /**
     * 更改购物车中的某个商品的数目
     *
     * @param cartId
     * @param goodsNum
     * @return
     */
    @Override
    public int updateGoodsNum(Integer cartId, Integer goodsNum) {
        // 先判断这个数字是否合法，并且不能超过库存
        ShoppingCart shoppingCart = shoppingCartMapper.selectByPrimaryKeyCascade(cartId);
        // 没有查到任何结果
        if (shoppingCart == null) {
            return 0;
        }
        int stock = shoppingCart.getGoods().getStock();
        if (goodsNum > stock || goodsNum <= 0) {
            return 0;
        }
        shoppingCart.setNum(goodsNum);
        int res = shoppingCartMapper.updateByPrimaryKeySelective(shoppingCart);
        return res;
    }

    /**
     * 用户删除自己购物车中的商品
     *
     * @param cartId 商品在购物车的id
     * @return 删除的数据行数
     */
    @Override
    public int deleteGoodsInCart(Integer cartId) {
        int deleteLineNum = 0;
        User user = SessionUtil.getUserFromSession();
        // 确定是不是本人的操作
        ShoppingCart shoppingCart = shoppingCartMapper.selectByPrimaryKeyCascade(cartId);
        if (user.getUserId().equals(shoppingCart.getUserId())) {
            deleteLineNum = shoppingCartMapper.deleteByPrimaryKey(cartId);
        }
        return deleteLineNum;
    }

    /**
     * 新增某个商品进入购物车
     *
     * @param goodsId 待新增商品的id
     * @return
     */
    @Override
    public int addGoodsIntoCart(Integer goodsId) {
        // 查询这个商品
        Goods goods = goodsService.selectGoodsById(goodsId);
        //TODO: 进行逻辑判断

        User user = SessionUtil.getUserFromSession();
        // 生成新的购物车记录
        ShoppingCart shoppingCart = ShoppingCart.shoppingCartFactory(goods, user.getUserId());
        // 插入数据库
        int resLineNum = shoppingCartMapper.insertSelective(shoppingCart);
        return resLineNum;
    }
}
