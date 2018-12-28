package cn.edu.zzuli.service.shop;

import cn.edu.zzuli.bean.Goods;
import cn.edu.zzuli.bean.Shop;

import java.util.List;

/**
 * @ClassName ShopService
 * @Description 商店的一些操作
 * @Author 任耀
 * @Date 2018/12/24 19:09
 * @Version 1.0
 */
public interface ShopService {

    /**
     * 查询这个店名是否存在
     *
     * @param shopName
     * @return
     */
    public boolean shopNameIsExist(String shopName);

    /**
     * 新增一个商店
     */
    public int addShop(Shop shop);

    /**
     * 通过名字模糊查询商店
     *
     * @param shopName
     * @return
     */
    List<Shop> selectShopByName(String shopName);

    /**
     * 通过店主id去得到商店
     *
     * @param userId
     * @return
     */
    Shop getShopByShopperId(Integer userId);

    /**
     *
     * @param shop
     * @return
     */
    int updateShopByShopId(Shop shop);
}
