package cn.edu.zzuli.mapper;

import cn.edu.zzuli.bean.Shop;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ShopMapper {
    int deleteByPrimaryKey(Integer shId);

    int insert(Shop record);

    int insertSelective(Shop record);

    Shop selectByPrimaryKey(Integer shId);

    int updateByPrimaryKeySelective(Shop record);

    int updateByPrimaryKey(Shop record);

    /**
     * 查出所有这个名字的店铺
     * @param shopName
     * @return
     */
    List<Shop> selectShopByName(@Param(value = "shopName") String shopName);
}