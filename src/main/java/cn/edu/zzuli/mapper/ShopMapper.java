package cn.edu.zzuli.mapper;

import cn.edu.zzuli.bean.Shop;

public interface ShopMapper {
    int deleteByPrimaryKey(Integer shId);

    int insert(Shop record);

    int insertSelective(Shop record);

    Shop selectByPrimaryKey(Integer shId);

    int updateByPrimaryKeySelective(Shop record);

    int updateByPrimaryKey(Shop record);
}