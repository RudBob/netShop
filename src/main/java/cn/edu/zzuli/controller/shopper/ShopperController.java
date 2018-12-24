package cn.edu.zzuli.controller.shopper;

import cn.edu.zzuli.service.shopper.ShopperService;
import cn.edu.zzuli.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName shopperController
 * @Description 店家的一些简单操作
 * @Author 任耀
 * @Date 2018/12/24 18:14
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "shopper")
public class ShopperController {
    @Autowired
    private ShopperService shopperService;

    /**
     * 当用户申请成为一个店家之前，判断其是否有资格申请。
     *
     * @return
     */
    @RequestMapping(value = "weatherCanBecomeShopper", method = RequestMethod.GET)
    public Msg weatherCanBecomeShopper() {
        // 信息不完善的话返回false
        boolean res = shopperService.weatherCanBecomeShopper();
        if (!res) {
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 成为一个店家，应该有一个自己的商店。
     *
     * @return
     */
    @RequestMapping(value = "becomeShopper", method = RequestMethod.GET)
    public Msg becomeShopper(@RequestParam(value = "shopName") String shopName) {
        // 信息不完善的话返回false
        boolean res = shopperService.becomeShopper(shopName);
        if (res) {
            return Msg.success();
        }
        return Msg.fail();
    }

}
