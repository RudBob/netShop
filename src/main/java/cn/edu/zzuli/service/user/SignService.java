package cn.edu.zzuli.service.user;

import org.springframework.stereotype.Service;

/**
 * @ClassName SignService
 * @Description 进行注册用户和注销用户
 * @Author 任耀
 * @Date 2018/12/22 21:16
 * @Version 1.0
 */
public interface SignService {
    /**
     * 通过用户的手机号注册用户
     * @param tel
     * @param code
     * @param pwd
     * @return
     */
    boolean registerByTel(String tel, String code, String pwd);

    /**
     * 通过用户的E-mail注册用户
     * @param email
     * @param pwd
     * @return
     */
    boolean registerByEmail(String email, String pwd,String userName);

}
