package cn.edu.zzuli.controller.user.signup;

import cn.edu.zzuli.service.user.EmailSignUpService;
import cn.edu.zzuli.service.user.SignService;
import cn.edu.zzuli.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName EmailSignUpController
 * @Description 用户使用邮箱进行注册
 * @Author 任耀
 * @Date 2018/12/23 15:56
 * @Version 1.0
 */
@Api(description = "邮箱注册相关API")
@RestController
@RequestMapping("emailSignUp")
public class EmailSignUpController {
    @Autowired
    EmailSignUpService signService;

    /**
     * 邮件注册
     *
     * @return
     */
    @RequestMapping(value = "registerByEmail", method = RequestMethod.POST)
    public Msg registerByEmail(@RequestParam(value = "email", required = true) String email,
                               @RequestParam(value = "pwd", required = true) String pwd,
                               @RequestParam(value = "userName", required = true) String userName
    ) {
        boolean res = signService.registerByEmail(email, pwd, userName);
        if (res) {
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 校验邮箱
     */
    @RequestMapping(value = "confirmEmail", method = RequestMethod.GET)
    public Msg confirmEmail(@RequestParam(value = "email", required = true) String email,
                            @RequestParam(value = "code", required = true) String code) {
        boolean res = signService.confirmEmail(email, code);
        if (res) {
            return Msg.success();
        }
        return Msg.fail();
    }
}
