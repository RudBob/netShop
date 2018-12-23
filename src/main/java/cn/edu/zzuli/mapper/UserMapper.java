package cn.edu.zzuli.mapper;

import cn.edu.zzuli.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User login(@Param("userName") String userName,@Param("pwd")String password);

    void addUser(@Param("user") User user);
}
