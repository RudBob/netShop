package cn.edu.zzuli.service.shopper.impl;

import cn.edu.zzuli.bean.Shop;
import cn.edu.zzuli.bean.User;
import cn.edu.zzuli.mapper.ShopMapper;
import cn.edu.zzuli.service.shopper.ShopperService;
import cn.edu.zzuli.service.user.UserService;
import cn.edu.zzuli.util.BaseUtil;
import cn.edu.zzuli.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    HttpServletRequest request;

    @Autowired
    ShopMapper shopMapper;
    @Autowired
    UserService userService;

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
        List<Shop> shops = shopMapper.selectShopByName(shopName);
        if (shops.size() != 0) {
            return false;
        }
        // 改变用户的role，生成一个新的商店。
        User user = SessionUtil.getUserFromSession();
        userService.becomeShopper(user);
        SessionUtil.updateUserInSession(user);
        // 生成一个新店.
        Shop shop = Shop.shopFactory(shopName, user);
        shopMapper.insert(shop);
        return true;
    }

    /**
     * 判断商店的名字是否存在
     *
     * @param shopName
     * @return
     */
    public boolean shopNameIsExist(String shopName) {
        List<Shop> shops = shopMapper.selectShopByName(shopName);
        return shops.size() != 0;
    }

}
