package cn.edu.zzuli.mapper;

import cn.edu.zzuli.bean.CartDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CartDetailMapper {
    int deleteByPrimaryKey(Integer detailId);

    int insert(CartDetail record);

    int insertSelective(CartDetail record);

    CartDetail selectByPrimaryKey(Integer detailId);

    int updateByPrimaryKeySelective(CartDetail record);

    int updateByPrimaryKey(CartDetail record);

    List<CartDetail> selectCartByInfo(Map<String, Object> info);
}