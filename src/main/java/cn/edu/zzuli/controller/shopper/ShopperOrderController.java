package cn.edu.zzuli.controller.shopper;

import cn.edu.zzuli.bean.UserOrder;
import cn.edu.zzuli.service.shopper.ShopperOrderService;
import cn.edu.zzuli.util.BaseUtil;
import cn.edu.zzuli.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 店主(客服)对订单的管理
 */
@RestController
@RequestMapping(value = "/shopper/order")
public class ShopperOrderController {
    @Autowired
    ShopperOrderService shopperOrderService;

    /**
     * 修改订单信息
     */
    @RequestMapping(value = "updateOrderInfo", method = RequestMethod.POST)
    public Msg updateOrderInfo(@RequestBody UserOrder userOrder) {
        int resLine = shopperOrderService.updateOrderInfo(userOrder);
        return BaseUtil.resLineToMsg(resLine);
    }

    /**
     * 将订单状态改为等待揽收
     *
     * @param orderId 发货的id
     * @return Msg
     */
    @RequestMapping(value = "waitDeliver", method = RequestMethod.POST)
    public Msg waitDeliver(@RequestParam(value = "orderId") Integer orderId) {
        // 不允许店家修改订单的时间
        int resLine = shopperOrderService.waitDeliver(orderId);
        return BaseUtil.resLineToMsg(resLine);
    }


}
