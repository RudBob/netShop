package cn.edu.zzuli.controller.user.signup;

import cn.edu.zzuli.service.user.TelSignUpService;
import cn.edu.zzuli.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TelSignUp
 * @Description 手机号注册相关API
 * @Author 任耀
 * @Date 2018/12/23 15:58
 * @Version 1.0
 */
@Api(description = "手机号注册相关API")
@RestController
@RequestMapping("/telSignUp")
public class TelSignUpController {
    @Autowired
    TelSignUpService signService;

    /**
     * 手机号注册。
     *
     * @return Msg
     */
    @RequestMapping(value = "registerByTel", method = RequestMethod.POST)
    public Msg registerByTel(@RequestParam(value = "tel") String tel,
                             @RequestParam(value = "code") String code,
                             @RequestParam(value = "pwd") String pwd) {
        boolean res = signService.registerByTel(tel, code, pwd);
        if (res) {
            return Msg.success();
        }
        return Msg.fail();
    }

}
