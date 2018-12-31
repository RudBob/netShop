package cn.edu.zzuli.service.user;


import cn.edu.zzuli.bean.User;
import cn.edu.zzuli.bean.UserMoney;

public interface UserMoneyService {
    /**
     * 开通花钱宝
     *
     * @param payPwd 支付密码
     * @return
     */
    int addPay(String payPwd);

    /**
     * 更新用户密码
     *
     * @param oldPwd 老密码
     * @param newPwd 新密码
     * @return
     */
    int updatePayPwd(String oldPwd, String newPwd);

    UserMoney getUserMoneyByUserId(Integer userId);

    boolean checkPwd(Integer userId, String payPwd);

    void transferMoney(User user, User shopper, double allPrice);
}
