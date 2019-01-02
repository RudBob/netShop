package cn.edu.zzuli.service.shopper.impl;

import cn.edu.zzuli.bean.Shop;
import cn.edu.zzuli.bean.User;
import cn.edu.zzuli.enums.user_enum.UserRoleEnum;
import cn.edu.zzuli.mapper.UserMapper;
import cn.edu.zzuli.service.shop.ShopService;
import cn.edu.zzuli.service.shopper.ShopperService;
import cn.edu.zzuli.service.user.UserService;
import cn.edu.zzuli.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName ShopperServiceImpl
 * @Description 店家的一些操作
 * @Author 任耀
 * @Date 2018/12/24 18:24
 * @Version 1.0
 */
@Service
public class ShopperServiceImpl implements ShopperService {
    @Autowired
    ShopService shopService;
    @Autowired
    UserMapper userMapper;

    /**
     * 判断一个用户的信息是否足够完整，以便于开店。
     *
     * @return
     */
    public boolean weatherCanBecomeShopper() {
        User user = SessionUtil.getUserFromSession();
        //判断用户信息主要有：邮箱，手机号。
        // 之后再加实名认证
        return user.getEmail() == null || user.getTel() == null;
    }

    /**
     * 一个用户升级为店主，并拥有一个商店
     *
     * @param shopName 商店名
     * @return
     */
    public boolean becomeShopper(String shopName) {
        //先判断一个店的名字是否存在.
        if (shopService.shopNameIsExist(shopName)) {
            return false;
        }
        // 改变用户的role，生成一个新的商店。
        User user = SessionUtil.getUserFromSession();
        // 用户已经是店家了
        if (user.getRole().equals(UserRoleEnum.SHOPPER)) {
            return false;
        }
        user.setRole(UserRoleEnum.SHOPPER);
        userMapper.updateUser(user);
        SessionUtil.updateUserInSession(user);
        // 生成一个新店.
        Shop shop = Shop.shopFactory(shopName, user);
        shopService.addShop(shop);
        return true;
    }

    /**
     * 通过商店id得到店主的id，转账给店主
     *
     * @param shId
     * @return 通过商店id得到店主
     */
    @Override
    public User getShopperByShopId(Integer shId) {
        // 得到店主的userId
        int shopperId = shopService.selectByPKey(shId);
        // 查询User表
        User user = userMapper.selectUserById(shopperId);
        return user;
    }

}
