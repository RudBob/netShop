package cn.edu.zzuli.controller.user.userMoney;

import cn.edu.zzuli.service.user.UserMoneyService;
import cn.edu.zzuli.util.BaseUtil;
import cn.edu.zzuli.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "用户余额的一些简单操作")
@RestController
@RequestMapping(value = "/user/money")
public class UserMoneyController {
    @Autowired
    UserMoneyService userMoneyService;
    /**
     * 开通花钱宝，更新操作密码,充值(银行卡充值,网上接口充值)
     */

    /**
     * 开通花钱宝
     *
     * @return
     */
    @RequestMapping(value = "addPay", method = RequestMethod.POST)
    public Msg addPay(@RequestParam(value = "payPwd") String payPwd) {
        int resLine = userMoneyService.addPay(payPwd);
        return BaseUtil.resLineToMsg(resLine);
    }

    /**
     * 更新支付密码
     *
     * @return Msg
     */
    @RequestMapping(value = "updateMoneyPwd", method = RequestMethod.POST)
    public Msg updateMoneyPwd(@RequestParam(value = "newPwd") String newPwd,
                              @RequestParam(value = "oldPwd") String oldPwd) {
        int resLine = userMoneyService.updatePayPwd(oldPwd, newPwd);
        return BaseUtil.resLineToMsg(resLine);
    }

    /**
     * 充值金额,
     */
    @RequestMapping(value = "recharge", method = RequestMethod.POST)
    public Msg addMoney(@RequestParam(value = "moneyNum") Double moneyNum) {
        boolean res = userMoneyService.recharge(moneyNum);
        return BaseUtil.resLineToMsg(res);
    }

    /**
     * 提现金额,
     */
    @RequestMapping(value = "withdrawCash", method = RequestMethod.POST)
    public Msg withdrawCash(@RequestParam(value = "moneyNum") Double moneyNum) {
        boolean res = userMoneyService.withdrawCash(moneyNum);
        return BaseUtil.resLineToMsg(res);
    }
}
