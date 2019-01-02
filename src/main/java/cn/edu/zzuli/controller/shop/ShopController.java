package cn.edu.zzuli.controller.shop;

import cn.edu.zzuli.bean.Shop;
import cn.edu.zzuli.service.shop.ShopService;
import cn.edu.zzuli.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName ShopController
 * @Description 商店的一些操作
 * @Author 任耀
 * @Date 2018/12/25 8:27
 * @Version 1.0
 */
@Api(description = "商店的一些操作")
@RequestMapping(value = "/shop")
@RestController
public class ShopController {
    @Autowired
    ShopService shopService;

    /**
     * 拆线呢商店名字是否可用
     *
     * @param shopName 店名
     * @return 可用：success
     */
    @RequestMapping(value = "queryShopName", method = RequestMethod.GET)
    public Msg queryShopNameWeatherCanUse(@RequestParam(value = "queryShopNameWeatherCanUse") String shopName) {
        boolean res = shopService.shopNameIsExist(shopName);
        if (res) {
            return Msg.fail();
        } else {
            return Msg.success();
        }
    }

    /**
     * 通过店名查询商店
     *
     * @param shopName 店名
     * @return Msg
     */
    @RequestMapping(value = "selectShopByName", method = RequestMethod.GET)
    public Msg selectShopByName(@RequestParam(value = "shopName") String shopName) {
        List<Shop> shops = shopService.selectShopByName(shopName);
        if (shops == null || shops.size() == 0) {
            return Msg.fail();
        } else {
            return Msg.success().addResData("shops", shops);
        }
    }
}
