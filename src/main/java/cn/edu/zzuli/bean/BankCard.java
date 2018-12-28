package cn.edu.zzuli.bean;

/**
 * 银行卡
 */
public class BankCard {
    /**
     * 主键
     */
    private Integer cardId;
    /**
     * 卡号
     */
    private String cardNum;
    /**
     * 银行名
     */
    private String bankName;
    /**
     * 用户余额的id，(一对多的关系)
     */
    private Integer userMoneyId;

    @Override
    public String toString() {
        return "BankCard{" +
                "cardId=" + cardId +
                ", cardNum='" + cardNum + '\'' +
                ", bankName='" + bankName + '\'' +
                ", userMoneyId=" + userMoneyId +
                '}';
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum == null ? null : cardNum.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public Integer getUserMoneyId() {
        return userMoneyId;
    }

    public void setUserMoneyId(Integer userMoneyId) {
        this.userMoneyId = userMoneyId;
    }

}