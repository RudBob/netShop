package cn.edu.zzuli.mapper;

import cn.edu.zzuli.bean.GoodsOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsOrderMapper {
    int deleteByPrimaryKey(Integer goodsOrderId);

    int insert(GoodsOrder record);

    int insertSelective(GoodsOrder record);

    GoodsOrder selectByPrimaryKey(Integer goodsOrderId);

    int updateByPrimaryKeySelective(GoodsOrder record);

    int updateByPrimaryKey(GoodsOrder record);
}