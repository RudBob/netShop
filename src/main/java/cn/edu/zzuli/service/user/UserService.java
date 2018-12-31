package cn.edu.zzuli.service.user;


/**
 * 用户操作的相关Service
 */
public interface UserService {

    int updateUserTel(String tel, String idCode);

    void confirmTel(String tel);
}
