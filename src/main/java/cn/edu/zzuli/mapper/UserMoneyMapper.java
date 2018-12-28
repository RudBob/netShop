package cn.edu.zzuli.mapper;

import cn.edu.zzuli.bean.UserMoney;
import org.apache.ibatis.annotations.Param;

public interface UserMoneyMapper {
    int deleteByPrimaryKey(Integer umId);

    int insert(UserMoney record);

    int insertSelective(UserMoney record);

    UserMoney selectByPrimaryKey(Integer umId);

    int updateByPrimaryKeySelective(UserMoney record);

    int updateByPrimaryKey(UserMoney record);

    UserMoney selectByUserId_Pwd(@Param(value = "userId") Integer userId, @Param(value = "payPwd") String payPwd);

}