package cn.edu.zzuli.service.user.impl;

import cn.edu.zzuli.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @Author 任耀
 * @Description 用户相关操作实现
 * @Date  2018/12/17  16点26分
 * @return
 */
@Service
public class UserServiceImpl {
    @Autowired
    UserMapper userMapper;
}
