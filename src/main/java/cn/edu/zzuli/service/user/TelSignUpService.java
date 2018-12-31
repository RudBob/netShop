package cn.edu.zzuli.service.user;

/**
 * @ClassName TelSignUpService
 * @Description 通过用户的手机号注册用户
 * @Author 任耀
 * @Date 2018/12/23 16:00
 * @Version 1.0
 */
public interface TelSignUpService {
    /**
     * 通过用户的手机号注册用户
     * @param tel
     * @param code
     * @param pwd
     * @return
     */
    boolean registerByTel(String tel, String code, String pwd);

    void confirmTel(String tel);
}
