package cn.edu.zzuli.mapper;

import cn.edu.zzuli.bean.OrderData;

public interface OrderDataMapper {
    int deleteByPrimaryKey(Integer goodsOrderId);

    int insert(OrderData record);

    int insertSelective(OrderData record);

    OrderData selectByPrimaryKey(Integer goodsOrderId);

    int updateByPrimaryKeySelective(OrderData record);

    int updateByPrimaryKey(OrderData record);
}