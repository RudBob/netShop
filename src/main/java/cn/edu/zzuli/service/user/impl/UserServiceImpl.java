package cn.edu.zzuli.service.user.impl;

import cn.edu.zzuli.bean.User;
import cn.edu.zzuli.mapper.UserMapper;
import cn.edu.zzuli.service.user.UserService;
import cn.edu.zzuli.util.userDataSetting.UserRoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @Author 任耀
 * @Description 用户相关操作实现
 * @Date  2018/12/17  16点26分
 * @return
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public boolean becomeShopper(User user) {
        // 用户已经是店家了
        if(user.getRole().equals(UserRoleEnum.SHOPPER)){
            return false;
        }
        user.setRole(UserRoleEnum.SHOPPER);
        userMapper.updateUser(user);
        return true;
    }
}
