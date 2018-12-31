package cn.edu.zzuli.service.shopper;

import cn.edu.zzuli.bean.User;

/**
 * @ClassName ShopperService
 * @Description 商店的相关操作
 * @Author 任耀
 * @Date 2018/12/24 18:38
 * @Version 1.0
 */
public interface ShopperService {
    /**
     * 判断一个用户的信息是否足够完整，以便于开店。
     *
     * @return 成功/失败
     */
    boolean weatherCanBecomeShopper();

    /**
     * 开店！
     *
     * @param shopName 商店名
     * @return 成功/失败
     */
    boolean becomeShopper(String shopName);

    /**
     * 通过商店的id得到店主
     * @param shId
     * @return
     */
    User getShopperByShopId(Integer shId);
}
