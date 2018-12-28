package cn.edu.zzuli.mapper;

import cn.edu.zzuli.bean.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ShoppingCartMapper {
    int deleteByPrimaryKey(Integer cartId);

    int insert(ShoppingCart record);

    int insertSelective(ShoppingCart record);

    ShoppingCart selectByPrimaryKey(Integer cartId);

    ShoppingCart selectByPrimaryKeyCascade(Integer cartId);

    int updateByPrimaryKeySelective(ShoppingCart record);

    int updateByPrimaryKey(ShoppingCart record);

    List<ShoppingCart> selectCartByInfoCascade(Map<String,Object> info);

}