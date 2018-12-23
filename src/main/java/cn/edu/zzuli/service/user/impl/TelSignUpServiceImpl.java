package cn.edu.zzuli.service.user.impl;

import cn.edu.zzuli.mapper.UserMapper;
import cn.edu.zzuli.service.user.TelSignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName TelSignUpServiceImpl
 * @Description 手机注册账号的相关操作
 * @Author 任耀
 * @Date 2018/12/23 16:02
 * @Version 1.0
 */
@Service
public class TelSignUpServiceImpl implements TelSignUpService {
    @Autowired
    UserMapper userMapper;

    /**
     * 通过用户的手机号注册用户
     *
     * @param tel
     * @param code
     * @param pwd
     * @return
     */
    @Override
    public boolean registerByTel(String tel, String code, String pwd) {

        return false;
    }
}
