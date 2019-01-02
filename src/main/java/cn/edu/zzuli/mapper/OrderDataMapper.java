package cn.edu.zzuli.mapper;

import cn.edu.zzuli.bean.OrderData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderDataMapper {
    int deleteByPrimaryKey(Integer goodsOrderId);

    int insert(OrderData record);

    int insertSelective(OrderData record);

    OrderData selectByPrimaryKey(Integer goodsOrderId);

    int updateByPrimaryKeySelective(OrderData record);

    int updateByPrimaryKey(OrderData record);

    List<OrderData> selectByOrderId(@Param(value = "orderId") Integer orderId);
}