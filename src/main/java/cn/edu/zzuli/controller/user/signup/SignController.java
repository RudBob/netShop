package cn.edu.zzuli.controller.user.signup;

import cn.edu.zzuli.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SignController
 * @Description 用户的注册注销类
 * @Author 任耀
 * @Date 2018/12/18 21:05
 * @Version 1.0
 */
@Api(description = "用户的注册注销类api")
@RestController
@RequestMapping("/signDown")
public class SignController {

    /**
     * 注销用户账号，消灭这个用户的所有隐私信息
     *
     * @return
     */
    @RequestMapping(value = "signDown", method = RequestMethod.POST)
    public Msg signDown() {

        return Msg.success();
    }
}
