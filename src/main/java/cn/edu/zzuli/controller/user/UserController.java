package cn.edu.zzuli.controller.user;

import cn.edu.zzuli.bean.User;
import cn.edu.zzuli.service.user.UserService;
import cn.edu.zzuli.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户注册，注销，修改信息等操作
 */
@Api(description = "对用户的一些简单操作")
@RestController
@RequestMapping(value = "user")
public class UserController {
    // 今天，完成用户的注册，注销，修改。
    @Autowired
    UserService userService;

    /**
     * 修改个人信息
     *
     * @return
     */
    @RequestMapping(value = "updateUser", method = RequestMethod.POST)
    public Msg updateUser(User user) {

        return Msg.success();
    }

    /**
     * 修改手机号
     *
     * @return
     */
    @RequestMapping(value = "updateUserTel", method = RequestMethod.POST)
    public Msg updateUserTel(@RequestParam(value = "tel") String tel,
                             @RequestParam(value = "idCode") String idCode
    ) {
        int res = userService.updateUserTel(tel, idCode);
        if (res == 1) {
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 验证手机号
     */
    @RequestMapping(value = "confirmTel", method = RequestMethod.POST)
    public Msg confirmTel(@RequestParam(value = "tel") String tel) {
        userService.confirmTel(tel);
        return Msg.success();
    }
}
