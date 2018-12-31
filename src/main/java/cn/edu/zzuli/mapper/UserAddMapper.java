package cn.edu.zzuli.mapper;

import cn.edu.zzuli.bean.UserAdd;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserAddMapper {
    int deleteByPrimaryKey(Integer addId);

    int insert(UserAdd record);

    int insertSelective(UserAdd record);

    UserAdd selectByPrimaryKey(Integer addId);

    int updateByPrimaryKeySelective(UserAdd record);

    int updateByPrimaryKey(UserAdd record);
}