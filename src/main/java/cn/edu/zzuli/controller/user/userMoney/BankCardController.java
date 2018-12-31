package cn.edu.zzuli.controller.user.userMoney;

import cn.edu.zzuli.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "用户对自己的银行卡进行操作")
@RestController
@RequestMapping(value = "/user/bankCard")
public class BankCardController {

    /**
     * 银行卡主要有：新增银行卡,删除银行卡,取款(只进行查询余额操作，将取款操作加入队列(银行锁死这笔钱)，等待银行方面响应)，充值银行卡
     */

    /**
     * 新增一个银行卡
     *
     * @return
     */
    @RequestMapping(value = "addBankCard", method = RequestMethod.POST)
    public Msg addBankCard() {
        return Msg.success();
    }
}
