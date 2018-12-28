package cn.edu.zzuli.mapper;

import cn.edu.zzuli.bean.BankCard;

public interface BankCardMapper {
    int deleteByPrimaryKey(Integer cardId);

    int insert(BankCard record);

    int insertSelective(BankCard record);

    BankCard selectByPrimaryKey(Integer cardId);

    int updateByPrimaryKeySelective(BankCard record);

    int updateByPrimaryKey(BankCard record);
}