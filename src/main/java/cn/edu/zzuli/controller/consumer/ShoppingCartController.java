package cn.edu.zzuli.controller.consumer;

import cn.edu.zzuli.bean.ShoppingCart;
import cn.edu.zzuli.service.consumer.ShoppingCartService;
import cn.edu.zzuli.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        List<ShoppingCart> userShoppingCart = shoppingCartService.showCart();
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
        int updateLineNum = shoppingCartService.updateGoodsNum(cartId, goodsNum);
        if (updateLineNum == 0) {
            return Msg.fail();
        }
        return Msg.success();
    }

    /**
     * 删除购物车中某个商品
     *
     * @param cartId 待删除商品的id
     * @return
     */
    @RequestMapping(value = "deleteGoodsInCart", method = RequestMethod.GET)
    public Msg deleteGoodsInCart(@RequestParam(value = "cartId") Integer cartId) {
        int deleteLineNum = shoppingCartService.deleteGoodsInCart(cartId);
        if (deleteLineNum == 0) {
            return Msg.fail();
        } else {
            return Msg.success();
        }
    }

    /**
     * 新增某个商品进入购物车
     *
     * @param goodsId 待删除商品的id
     * @return
     */
    @RequestMapping(value = "addGoodsIntoCart", method = RequestMethod.GET)
    public Msg addGoodsIntoCart(@RequestParam(value = "goodsId") Integer goodsId) {
        int addLineNum = shoppingCartService.addGoodsIntoCart(goodsId);
        if (addLineNum == 0) {
            return Msg.fail();
        } else {
            return Msg.success();
        }
    }

}
