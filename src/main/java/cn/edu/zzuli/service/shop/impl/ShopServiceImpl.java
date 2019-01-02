package cn.edu.zzuli.service.shop.impl;

import cn.edu.zzuli.bean.Shop;
import cn.edu.zzuli.mapper.ShopMapper;
import cn.edu.zzuli.service.shop.ShopService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ShopServiceImpl
 * @Description 商店的一些操作
 * @Author 任耀
 * @Date 2018/12/24 19:09
 * @Version 1.0
 */
@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    ShopMapper shopMapper;


    /**
     * 判断商店的名字是否存在
     *
     * @param shopName
     * @return
     */
    @Override
    public boolean shopNameIsExist(String shopName) {
        List<Shop> shops = shopMapper.selectShopByName(shopName);
        return shops != null && shops.size() != 0;
    }

    @Override
    public int addShop(Shop shop) {
        return shopMapper.insert(shop);
    }


    /**
     * 通过名字直接模糊查询商店
     *
     * @param shopName
     * @return
     */
    @Override
    public List<Shop> selectShopByName(String shopName) {
        List<Shop> shops = shopMapper.selectShopsByNameLike(shopName);
        return shops;
    }

    /**
     * 通过店主的userId查询商店
     *
     * @param userId 用户id
     * @return Shop
     */
    @Override
    public Shop getShopByShopperId(Integer userId) {
        return shopMapper.getShopByShopperId(userId);
    }

    @Override
    public int updateShopByShopId(Shop shop) {
        return shopMapper.updateByPrimaryKey(shop);
    }

    @Override
    public int selectByPKey(Integer shId) {
        return shopMapper.selectByPrimaryKey(shId).getShopper().getUserId();
    }

}
