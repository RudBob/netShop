package cn.edu.zzuli.service.user.impl;

import cn.edu.zzuli.bean.User;
import cn.edu.zzuli.mapper.UserMapper;
import cn.edu.zzuli.service.user.SignService;
import cn.edu.zzuli.util.EmailUtil;
import cn.edu.zzuli.util.FormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;

/**
 * @ClassName SignServiceImpl
 * @Description 用户的注册注销类
 * @Author 任耀
 * @Date 2018/12/22 21:17
 * @Version 1.0
 */
@Service
public class SignServiceImpl implements SignService {
    @Autowired
    UserMapper userMapper;
    /**
     * 通过用户的手机号注册用户
     * @param tel
     * @param code
     * @param pwd
     * @return
     */
    @Override
    public boolean registerByTel(String tel, String code, String pwd) {

        return false;
    }
    /**
     * 通过用户的E-mail注册用户
     * @param email
     * @param pwd
     * @return
     */
    @Override
    public boolean registerByEmail(String email, String pwd,String userName) {
        // 校验邮箱是否合法
        if(!FormatUtil.isEmail(email)){
            // 不合法则直接返回false
            return false;
        }
        //先将一个未激活的用户插入到数据库中
        User user = User.getNewUserByEmail(email,pwd,userName);
        userMapper.addUser(user);
        //TODO:用户合法则发送校验邮件
        judgeMail(email);
        return true;
    }

    @Autowired
    HttpServletRequest request;
    /**
     * 发送给他一个校验码。
     * @param email
     */
    private void judgeMail(String email) {
        HttpSession session = request.getSession();
        //生成随机验证码
        Random random = new Random();
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            code.append(random.nextInt(10));
        }
        EmailUtil.sendMail(email,code.toString());
    }
}
