package cn.edu.zzuli.service.user.impl;

import cn.edu.zzuli.bean.User;
import cn.edu.zzuli.mapper.UserMapper;
import cn.edu.zzuli.service.user.UserService;
import cn.edu.zzuli.util.FormatUtil;
import cn.edu.zzuli.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author 任耀
 * @Description 用户相关操作实现
 * @Date 2018/12/17  16点26分
 * @return
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    /**
     * 更新用户手机号
     *
     * @param tel
     * @param idCode
     * @return 状态码
     */
    @Override
    public int updateUserTel(String tel, String idCode) {
        User user = SessionUtil.getUserFromSession();
        if (!FormatUtil.isMobile(tel)) {
            // 手机号格式不对
            return 0;
        }
        user.setTel(tel);
        userMapper.updateUser(user);
        return 1;
    }

    @Override
    public void confirmTel(String tel) {

    }
}
