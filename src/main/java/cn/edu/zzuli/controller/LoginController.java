package cn.edu.zzuli.controller;

import cn.edu.zzuli.bean.User;
import cn.edu.zzuli.service.user.LoginService;
import cn.edu.zzuli.util.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ClassName LoginContorller
 * @Description 登入登出操作的Controller
 * @Author 任耀
 * @Date 2018/12/17 16:22
 * @Version 1.0
 */
@Api(description = "用户登录的api")
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
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名称", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "pwd", value = "用户密码", required = true, paramType = "query", dataType = "String")
    })
    @RequestMapping(value = "login",method = RequestMethod.POST)
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
    @RequestMapping(value = "logout",method = RequestMethod.POST)
    public Msg logout() {
        User user = loginService.logout();
        if (user == null) {
            // 用户不存在
            return Msg.fail().setMsg("网络问题，请刷新重试");
        }
        return Msg.success();
    }
}
