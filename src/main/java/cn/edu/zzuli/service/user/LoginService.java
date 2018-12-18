package cn.edu.zzuli.service.user;

import cn.edu.zzuli.bean.User;

import javax.servlet.http.HttpSession;

/**
 * 登录登出的接口
 * waring: 本类中返回的user将不含有pwd字段值
 */
public interface LoginService {
    /**
     * 用户登录,
     * @return 返回的user对象中将不会含有pwd字段
     */
    User login(String userName, String password, HttpSession httpSession);

    /**
     * 用户登出
     * @return 返回user以便于操作
     */
    User logout();
}
