package cn.edu.zzuli.controller.consumer;

import cn.edu.zzuli.bean.UserAddr;
import cn.edu.zzuli.service.consumer.ConsumerAddrService;
import cn.edu.zzuli.util.BaseUtil;
import cn.edu.zzuli.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 顾客对地址应该有增删改查四种操作
 */
@RestController
@RequestMapping(value = "user/addr")
public class ConsumerAddrManageController {
    @Autowired
    ConsumerAddrService consumerAddrService;

    /**
     * 展示用户所有的收货地址
     *
     * @return Msg
     */
    @RequestMapping(value = "showUserAllAddr", method = RequestMethod.GET)
    public Msg showUserAllAddr() {
        List<UserAddr> userAddrList = consumerAddrService.showUserAllAddr();
        if (userAddrList != null && userAddrList.size() != 0) {
            return Msg.success().addResData("userAddrList", userAddrList);
        } else {
            return Msg.fail();
        }
    }

    /**
     * 用户新增一个收货地址
     *
     * @param userAddr 收货地址
     * @return Msg
     */
    @RequestMapping(value = "addUserAddr", method = RequestMethod.POST)
    public Msg addUserAddr(@RequestBody UserAddr userAddr) {
        int resLine = consumerAddrService.addUserAddr(userAddr);
        return BaseUtil.resLineToMsg(resLine);
    }

    /**
     * 用户删除一个收货地址
     *
     * @param addrId 收货地址的编号
     * @return Msg
     */
    @RequestMapping(value = "deleteAddr", method = RequestMethod.POST)
    public Msg deleteAddr(@RequestParam(value = "addrId") Integer addrId) {
        int resLine = consumerAddrService.deleteAddr(addrId);
        return BaseUtil.resLineToMsg(resLine);
    }

    /**
     * 用户更新一个收货地址
     *
     * @param userAddr 收货地址
     * @return Msg
     */
    @RequestMapping(value = "updateAddr", method = RequestMethod.POST)
    public Msg updateAddr(@RequestBody UserAddr userAddr) {
        int resLine = consumerAddrService.updateAddr(userAddr);
        return BaseUtil.resLineToMsg(resLine);
    }


}
