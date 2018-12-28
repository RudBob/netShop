package cn.edu.zzuli.bean;

import java.util.List;

/**
 * 用户余额
 */
public class UserMoney {
    private Integer umId;
    /**
     * 余额数量
     */
    private Double money;
    /**
     * 支付密码
     */
    private String umPwd;
    /**
     * 用户id(1对1)
     */
    private Integer userId;
    /**
     * 银行卡(一对多)
     */
    private List<BankCard> bankCards;

    public UserMoney() {
    }

    public static UserMoney userMoneyFactory(Integer userId, String payPwd) {
        UserMoney userMoney = new UserMoney();
        userMoney.setUserId(userId);
        userMoney.setUmPwd(payPwd);
        userMoney.setMoney(0.0);
        return userMoney;
    }

    @Override
    public String toString() {
        return "UserMoney{" +
                "umId=" + umId +
                ", money=" + money +
                ", umPwd='" + umPwd + '\'' +
                ", userId=" + userId +
                ", bankCards=" + bankCards +
                '}';
    }

    public Integer getUmId() {
        return umId;
    }

    public void setUmId(Integer umId) {
        this.umId = umId;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getUmPwd() {
        return umPwd;
    }

    public void setUmPwd(String umPwd) {
        this.umPwd = umPwd == null ? null : umPwd.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<BankCard> getBankCards() {
        return bankCards;
    }

    public void setBankCards(List<BankCard> bankCards) {
        this.bankCards = bankCards;
    }
}