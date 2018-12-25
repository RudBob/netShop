package cn.edu.zzuli.service.shopper.impl;

import cn.edu.zzuli.bean.Shop;
import cn.edu.zzuli.bean.User;
import cn.edu.zzuli.service.shop.ShopService;
import cn.edu.zzuli.service.shopper.ShopperManageShopService;
import cn.edu.zzuli.util.SessionUtil;
import cn.edu.zzuli.enums.user_enum.UserRoleEnum;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName ShopperManageShopServiceImpl
 * @Description 店主对商店的管理
 * @Author 任耀
 * @Date 2018/12/25 10:17
 * @Version 1.0
 */
public class ShopperManageShopServiceImpl implements ShopperManageShopService {
    @Autowired
    ShopService shopService;

    @Override
    public boolean changeShopName(String shopName) {
        //得到用户的id
        User user = SessionUtil.getUserFromSession();
        // 用户必须是一个店家 且这个名字没有被占用
        if (user.getRole().equals(UserRoleEnum.SHOPPER) && !shopService.shopNameIsExist(shopName)) {
            //找到用户对应的商店
            Shop shop = shopService.getShopByShopperId(user.getUserId());
            shop.setShName(shopName);
            shopService.updateShopByShopId(shop);
        }
        return false;
    }
}
