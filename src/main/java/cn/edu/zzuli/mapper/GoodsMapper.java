package cn.edu.zzuli.mapper;

import cn.edu.zzuli.bean.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface GoodsMapper {
    int deleteByPrimaryKey(Integer goodsId);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer goodsId);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    List<Goods> selectGoodsByShopId(Integer shopId);

    List<Goods> selectGoodsByInfo(Map<String,Object> info);
}