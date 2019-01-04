package cn.edu.zzuli.controller.shopper;

import cn.edu.zzuli.service.shopper.ShopperManageShopService;
import cn.edu.zzuli.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName ShopperManageShopController
 * @Description 店主管理商店
 * @Author 任耀
 * @Date 2018/12/25 10:15
 * @Version 1.0
 */
@Api(description = "店主管理自己的商店")
@ResponseBody
@RequestMapping(value = "/shopperManageShop")
public class ShopperManageShopController {
    @Autowired
    ShopperManageShopService shopperManageShopService;

    @RequestMapping(value = "changeShopName", method = RequestMethod.POST)
    public Msg changeShopName(@RequestParam(value = "shopName") String shopName) {
        boolean res = shopperManageShopService.changeShopName(shopName);
        if (res) {
            return Msg.success();
        }
        return Msg.fail();
    }
    /**
     * 定义自家的优惠卷
     */

    /**
     * 后续添加：查看商店的数据.
     */
}
