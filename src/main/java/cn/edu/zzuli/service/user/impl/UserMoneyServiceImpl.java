package cn.edu.zzuli.service.user.impl;

import cn.edu.zzuli.bean.User;
import cn.edu.zzuli.bean.UserMoney;
import cn.edu.zzuli.mapper.UserMoneyMapper;
import cn.edu.zzuli.service.user.UserMoneyService;
import cn.edu.zzuli.util.SessionUtil;
import cn.edu.zzuli.util.encrypt_util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserMoneyServiceImpl implements UserMoneyService {
    @Autowired
    UserMoneyMapper userMoneyMapper;

    /**
     * 开通花钱宝
     *
     * @param payPwd 支付密码
     * @return 数据库中受影响的代码行数
     */
    @Override
    public int addPay(String payPwd) {
        // 加密密码
        payPwd = MD5Util.md5Pwd(payPwd);
        // 得到用户id
        int userId = SessionUtil.getUserIdFromSession();
        // 得到一个新生成的userMoney
        UserMoney userMoney = UserMoney.userMoneyFactory(userId, payPwd);
        // 操作数据库
        int resLine = userMoneyMapper.insert(userMoney);
        return resLine;
    }

    /**
     * 更新用户密码
     *
     * @param oldPwd 老密码
     * @param newPwd 新密码
     * @return 数据库中受影响的代码行数
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
     * @param userId userId
     * @return 返回一个UserMoney
     */
    @Override
    public UserMoney getUserMoneyByUserId(Integer userId) {
        UserMoney userMoney = userMoneyMapper.selectByUserId(userId);
        return userMoney;
    }

    /**
     * 检查支付密码
     *
     * @param userId 用户id
     * @param payPwd 支付密码
     * @return 查看密码是否正确
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
    @Transactional
    public void transferMoney(User user, User shopper, double allPrice) {
        UserMoney userMoney = userMoneyMapper.selectByUserId(user.getUserId());
        UserMoney shopperMoney = userMoneyMapper.selectByUserId(shopper.getUserId());
        userMoney.setMoney(userMoney.getMoney() - allPrice);
        shopperMoney.setMoney(shopperMoney.getMoney() + allPrice);
        userMoneyMapper.updateByPrimaryKey(userMoney);
        userMoneyMapper.updateByPrimaryKey(shopperMoney);
        if (userMoney.getMoney() < 0) {
            throw new RuntimeException("钱不够,进行回退");
        }
    }
    /**
     * 用户充值，增加余额
     * @param moneyNum  增加的钱数
     * @return  成功与否
     */
    @Override
    public boolean recharge(Double moneyNum) {
        int userId = SessionUtil.getUserIdFromSession();
        UserMoney userMoney = userMoneyMapper.selectByUserId(userId);
        userMoney.setMoney(userMoney.getMoney() + moneyNum);
        userMoneyMapper.updateByPrimaryKey(userMoney);
        return true;
    }

    /**
     * 用户提现，减少余额
     * @param moneyNum  减少的钱数
     * @return  成功与否
     */
    @Override
    public boolean withdrawCash(Double moneyNum) {
        int userId = SessionUtil.getUserIdFromSession();
        UserMoney userMoney = userMoneyMapper.selectByUserId(userId);
        userMoney.setMoney(userMoney.getMoney() - moneyNum);
        userMoneyMapper.updateByPrimaryKey(userMoney);
        return true;
    }
}
