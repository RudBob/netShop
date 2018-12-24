package cn.edu.zzuli.service.shopper;

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
     * @return
     */
    public boolean weatherCanBecomeShopper();

    /**
     * 开店！
     *
     * @param shopName 商店名
     * @return
     */
    public boolean becomeShopper(String shopName);

    /**
     * 判斷商店名字是否已经存在
     *
     * @param shopName 商店名
     */
    public boolean shopNameIsExist(String shopName);
}
