package cn.edu.zzuli.mapper;

import cn.edu.zzuli.bean.UserOrder;

public interface UserOrderMapper {
    int deleteByPrimaryKey(Integer uoId);

    int insert(UserOrder record);

    int insertSelective(UserOrder record);

    UserOrder selectByPrimaryKey(Integer uoId);

    int updateByPrimaryKeySelective(UserOrder record);

    int updateByPrimaryKey(UserOrder record);
}