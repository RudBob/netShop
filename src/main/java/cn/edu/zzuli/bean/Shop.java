package cn.edu.zzuli.bean;

public class Shop {
    private Integer shId;

    private String shName;

    private Integer fansNum;

    private Integer shopper;

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

    public Integer getShopper() {
        return shopper;
    }

    public void setShopper(Integer shopper) {
        this.shopper = shopper;
    }
}