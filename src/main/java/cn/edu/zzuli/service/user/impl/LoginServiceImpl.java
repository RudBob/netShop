package cn.edu.zzuli.service.user.impl;

import cn.edu.zzuli.bean.Shop;
import cn.edu.zzuli.bean.User;
import cn.edu.zzuli.enums.user_enum.UserRoleEnum;
import cn.edu.zzuli.mapper.UserMapper;
import cn.edu.zzuli.service.shop.ShopService;
import cn.edu.zzuli.service.user.LoginService;
import cn.edu.zzuli.util.encrypt_util.MD5Util;
import cn.edu.zzuli.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 登录操作的相关实现
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    ShopService shopService;

    /**
     * 用户登录操作。将用户存入session，如果他是店家，那么商店也应该被存入Session
     *
     * @param userName 用户名称
     * @param pwd      用户密码
     * @return
     */
    @Override
    public User login(String userName, String pwd) {
        //MD5 加密后再与数据库中的密码进行比对
        pwd = MD5Util.md5Pwd(pwd);
        // 通过userName和pwd得到数据库中对应的记录,
        User user = userMapper.login(userName, pwd);
        if (user != null) {
            user.setPwd(null);
            // 得到user对象， 存入Session中
            SessionUtil.putUserIntoSession(user);
            // 如果用户是一个店家，那么将商店的id放到
            if (user.getRole().equals(UserRoleEnum.SHOPPER)) {
                Shop shop = shopService.getShopByShopperId(user.getUserId());
                SessionUtil.putShopIntoSession(shop);
            }
        }
        return user;
    }

    /**
     * @return cn.edu.zzuli.bean.User
     * @Author 任耀
     * @Description 用户登出操作，将用户从session中移除
     * @Date 2018/12/17
     */
    @Override
    public User logout() {
        return SessionUtil.removeUserFromSession();
    }
}
