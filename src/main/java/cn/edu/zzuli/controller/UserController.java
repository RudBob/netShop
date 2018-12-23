package cn.edu.zzuli.controller;

import cn.edu.zzuli.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户注册，注销，修改信息等操作
 */
@Api(description = "对用户的一些简单操作")
@RestController
@RequestMapping(value = "user")
public class UserController {
    // 今天，完成用户的注册，注销，修改。
    /**
     * 修改个人信息
     * @return
     */
    @RequestMapping(value = "updateUser",method = RequestMethod.POST)
    public Msg updateUser(){

        return Msg.success();
    }


}
