package cn.edu.zzuli.bean;

public class Goods {
    private Integer goodsId;

    private String goodsName;

    private Integer shId;

    private Integer sales;

    private Double priceRefer;

    private Integer price;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public Integer getShId() {
        return shId;
    }

    public void setShId(Integer shId) {
        this.shId = shId;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Double getPriceRefer() {
        return priceRefer;
    }

    public void setPriceRefer(Double priceRefer) {
        this.priceRefer = priceRefer;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}