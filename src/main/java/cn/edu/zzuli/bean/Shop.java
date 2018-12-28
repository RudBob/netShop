package cn.edu.zzuli.bean;

/**
 * @ClassName Shop
 * @Description 商店
 * @Author 任耀
 * @Date 2018年12月27日 10点55分
 * @Version 1.0
 */
public class Shop {
    private Integer shId;

    private String shName;

    private Integer fansNum;

    private User shopper;

    public static Shop shopFactory(String shopName,User shopper){
        Shop shop = new Shop();
        shop.setShName(shopName);
        shop.setShopper(shopper);
        shop.setFansNum(0);
        return shop;
    }
    public Integer getShId() {
        return shId;
    }

    public void setShId(Integer shId) {
        this.shId = shId;
    }

    public String getShName() {
        return shName;
    }

    public void setShName(String shName) {
        this.shName = shName == null ? null : shName.trim();
    }

    public Integer getFansNum() {
        return fansNum;
    }

    public void setFansNum(Integer fansNum) {
        this.fansNum = fansNum;
    }

    public User getShopper() {
        return shopper;
    }

    public void setShopper(User shopper) {
        this.shopper = shopper;
    }
}