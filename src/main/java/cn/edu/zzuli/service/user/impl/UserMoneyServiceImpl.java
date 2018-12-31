package cn.edu.zzuli.service.user.impl;

import cn.edu.zzuli.bean.User;
import cn.edu.zzuli.bean.UserMoney;
import cn.edu.zzuli.mapper.UserMoneyMapper;
import cn.edu.zzuli.service.user.UserMoneyService;
import cn.edu.zzuli.util.SessionUtil;
import cn.edu.zzuli.util.encrypt_util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMoneyServiceImpl implements UserMoneyService {
    @Autowired
    UserMoneyMapper userMoneyMapper;

    /**
     * 开通花钱宝
     *
     * @param payPwd 支付密码
     * @return
     */
    @Override
    public int addPay(String payPwd) {
        User user = SessionUtil.getUserFromSession();
        UserMoney userMoney = UserMoney.userMoneyFactory(user.getUserId(), payPwd);
        userMoneyMapper.insert(userMoney);
        return 0;
    }

    /**
     * 更新用户密码
     *
     * @param oldPwd 老密码
     * @param newPwd 新密码
     * @return
     */
    @Override
    public int updatePayPwd(String oldPwd, String newPwd) {
        // 从session中获取到user
        User user = SessionUtil.getUserFromSession();
        UserMoney userMoney;
        if (!checkPwd(user.getUserId(), oldPwd)) {
            return 0;
        }
        userMoney = userMoneyMapper.selectByUserId(user.getUserId());
        // MD5加密后，再存入数据库
        newPwd = MD5Util.md5Pwd(newPwd);
        userMoney.setUmPwd(newPwd);
        int res = userMoneyMapper.updateByPrimaryKey(userMoney);
        return res;
    }

    /**
     * 得到用户的花钱宝，通过用户的userId
     *
     * @param userId
     * @return
     */
    @Override
    public UserMoney getUserMoneyByUserId(Integer userId) {
        UserMoney userMoney = userMoneyMapper.selectByUserId(userId);
        return userMoney;
    }

    /**
     * 检查支付密码
     *
     * @param userId
     * @param payPwd
     * @return
     */
    @Override
    public boolean checkPwd(Integer userId, String payPwd) {
        // MD5加密旧密码以便于与数据库中的密码进行比对
        payPwd = MD5Util.md5Pwd(payPwd);
        UserMoney userMoney = userMoneyMapper.selectByUserId(userId);
        return userMoney != null && userMoney.getUmPwd().equals(payPwd);
    }

    /**
     * 转账
     *
     * @param user     高浓度的钱包
     * @param shopper  低浓度的钱包
     * @param allPrice 支付金额
     */
    @Override
    public void transferMoney(User user, User shopper, double allPrice) {

    }
}
