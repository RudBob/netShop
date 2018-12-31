package cn.edu.zzuli.mapper;

import cn.edu.zzuli.bean.UserMoney;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMoneyMapper {
    int deleteByPrimaryKey(Integer umId);

    int insert(UserMoney record);

    int insertSelective(UserMoney record);

    UserMoney selectByPrimaryKey(Integer umId);

    int updateByPrimaryKeySelective(UserMoney record);

    int updateByPrimaryKey(UserMoney record);

    UserMoney selectByUserId(@Param(value = "userId") Integer userId);

}