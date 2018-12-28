package cn.edu.zzuli.service.user.impl;

import cn.edu.zzuli.bean.User;
import cn.edu.zzuli.mapper.UserMapper;
import cn.edu.zzuli.service.user.EmailSignUpService;
import cn.edu.zzuli.util.connection_util.EmailUtil;
import cn.edu.zzuli.util.FormatUtil;
import cn.edu.zzuli.util.encrypt_util.MD5Util;
import cn.edu.zzuli.enums.user_enum.UserStateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;

/**
 * @ClassName EmailSignUpServiceImpl
 * @Description 邮箱注册手机号的相关操作
 * @Author 任耀
 * @Date 2018/12/23 16:01
 * @Version 1.0
 */
@Service
public class EmailSignUpServiceImpl implements EmailSignUpService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    HttpServletRequest request;

    /**
     * 通过用户的E-mail注册用户
     *
     * @param email
     * @param pwd
     * @return
     */
    @Override
    public boolean registerByEmail(String email, String pwd, String userName) {
        // 校验邮箱是否合法
        if (!FormatUtil.isEmail(email)) {
            // 不合法则直接返回false
            return false;
        }
        // 加密密码
        pwd = MD5Util.md5Pwd(pwd);
        //先将一个未激活的用户插入到数据库中
        User user = User.getNewUserByEmail(email, pwd, userName);
        userMapper.addUser(user);
        //邮箱合法则发送校验邮件以便于激活用户
        judgeMail(email);
        return true;
    }

    @Override
    public boolean confirmEmail(String email, String code) {
        HttpSession session = request.getSession();
        String codeInSession = (String) session.getAttribute("code");
        if (code.equals(codeInSession)) {
            User user = userMapper.getUserByEmail(email);
            // 激活这个用户
            user.setState(UserStateEnum.NORMAL);
            userMapper.updateUser(user);
            return true;
        }
        return false;
    }


    /**
     * 发送给他一个校验码。
     *
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
        String massage = "您的邮箱是" + email + "，您的验证码是：" + code.toString() + "。如果不知道，请无视。";
        EmailUtil.sendMail(email, massage);
        session.setAttribute("code", code.toString());
    }
}
