package cn.edu.zzuli.controller.consumer;

import cn.edu.zzuli.bean.CartDetail;
import cn.edu.zzuli.service.consumer.ShoppingCartService;
import cn.edu.zzuli.util.BaseUtil;
import cn.edu.zzuli.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 顾客对自己购物车的操作
 */
@Api(description = "顾客对购物车的操作")
@RestController
@RequestMapping(value = "/shopCart")
public class ShoppingCartController {
    @Autowired
    ShoppingCartService shoppingCartService;

    /**
     * 展示用户的购物车.
     *
     * @return 用户购物车中的内容
     */
    @RequestMapping(value = "showCart", method = RequestMethod.GET)
    public Msg showUserCart() {
        List<CartDetail> userShoppingCart = shoppingCartService.showCart();
        if (userShoppingCart != null && userShoppingCart.size() != 0) {
            return Msg.success().addResData("shoppingCart", userShoppingCart);
        }
        return Msg.fail();
    }

    /**
     * 更新购物车中某个商品的数量
     *
     * @return 更新购物车中的数据的行数
     */
    @RequestMapping(value = "updateGoodsNum", method = RequestMethod.GET)
    public Msg updateGoodsNum(@RequestParam(value = "cartId") Integer cartId,
                              @RequestParam(value = "goodsNum") Integer goodsNum) {
        int resLine = shoppingCartService.updateGoodsNum(cartId, goodsNum);
        return BaseUtil.resLineToMsg(resLine);
    }

    /**
     * 删除购物车中某个商品
     *
     * @param cartId 待删除商品的id
     * @return
     */
    @RequestMapping(value = "deleteGoodsInCart", method = RequestMethod.GET)
    public Msg deleteGoodsInCart(@RequestParam(value = "cartId") Integer cartId) {
        int resLine = shoppingCartService.deleteGoodsInCart(cartId);
        return BaseUtil.resLineToMsg(resLine);
    }

    /**
     * 新增某个商品进入购物车
     *
     * @param goodsId 待删除商品的id
     * @return
     */
    @RequestMapping(value = "addGoodsIntoCart", method = RequestMethod.GET)
    public Msg addGoodsIntoCart(@RequestParam(value = "goodsId") Integer goodsId,
                                @RequestParam(value = "num", defaultValue = "1") Integer num) {
        int resLine = shoppingCartService.addGoodsIntoCart(goodsId, num);
        return BaseUtil.resLineToMsg(resLine);
    }

}
