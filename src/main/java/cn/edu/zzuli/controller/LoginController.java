package cn.edu.zzuli.controller;

import cn.edu.zzuli.bean.User;
import cn.edu.zzuli.service.user.LoginService;
import cn.edu.zzuli.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @ClassName LoginContorller
 * @Description 登入登出操作的Controller
 * @Author 任耀
 * @Date 2018/12/17 16:22
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "login")
public class LoginController {
    @Autowired
    LoginService loginService;
    /**
     * @Description 用户登录
     * @Date  2018/12/17  16:28
     * @Param [username, pwd]
     * @return cn.edu.zzuli.util.Msg
     */
    //TODO :多点登录时将上一个人挤下去
    @RequestMapping(value = "login")
    public Msg login(@RequestParam(value = "username",required = true) String username,
                     @RequestParam(value = "pwd",required = true) String pwd,
                     HttpSession session) {
        User user = loginService.login(username, pwd,session);
        if (user == null) {
            // 用户不存在
            return Msg.fail();
        }
        return Msg.success().addResData("user", user);
    }
    /**
     * @Description 用户登出
     * @Date  2018/12/17  16:27
     * @return cn.edu.zzuli.util.Msg
     */
    @RequestMapping(value = "logout")
    public Msg logout() {
        User user = loginService.logout();
        if (user == null) {
            // 用户不存在
            return Msg.fail().setMsg("网络问题，请刷新重试");
        }
        return Msg.success();
    }
}
