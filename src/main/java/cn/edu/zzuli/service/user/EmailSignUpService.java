package cn.edu.zzuli.service.user;

/**
 * @ClassName EmailSignUpService
 * @Description 用户通过邮箱注册的相关操作
 * @Author 任耀
 * @Date 2018/12/23 15:59
 * @Version 1.0
 */
public interface EmailSignUpService {

    /**
     * 通过用户的E-mail注册用户
     * @param email
     * @param pwd
     * @return
     */
    boolean registerByEmail(String email, String pwd,String userName);

    /**
     * 校验用户邮箱
     * @param email
     * @param code
     * @return
     */
    boolean confirmEmail(String email, String code);
}
