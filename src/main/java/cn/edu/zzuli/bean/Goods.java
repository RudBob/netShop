package cn.edu.zzuli.bean;

import cn.edu.zzuli.enums.goods_enum.GoodsEnum;

import java.util.Objects;

/**
 * 商品
 */
public class Goods {
    /**
     * 商品id
     */
    private Integer goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品所属商店的id
     */
    private Integer shId;
    /**
     * 商品销量
     */
    private Integer sales;
    /**
     * 商品参考价格
     */
    private Double priceRefer;
    /**
     * 价格
     */
    private Double price;
    /**
     * 库存量
     */
    private Integer stock;

    /**
     * 商品的状态吗
     */
    private GoodsEnum goodsEnum;

    public Goods() {
    }

    public Goods(Integer goodsId, String goodsName, Double price, Double priceRefer, Integer goodsStock) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.price = price;
        this.priceRefer = priceRefer;
        this.stock = goodsStock;
    }

    /**
     * 对一个商品来说，以下这些是必须的内容，必不可少
     *
     * @param goodsName  商品名称
     * @param priceRefer 参考价格
     * @param price      价格
     * @param shId       商店id
     * @return
     */
    public static Goods goodsFactory(String goodsName, Double priceRefer, Double price, Integer shId) {
        Integer goodsStock = 0;
        return goodsFactory(goodsName, priceRefer, price, shId, goodsStock);
    }

    /**
     * 最少必备，其余默认
     *
     * @param goodsName
     * @param price
     * @param shId
     * @return
     */
    public static Goods goodsFactory(String goodsName, Double price, Integer shId) {
        Double priceRefer = price;
        return goodsFactory(goodsName, priceRefer, price, shId);
    }

    public static Goods goodsFactory(String goodsName, Double priceRefer, Double price, Integer shId, Integer goodsStock) {
        Goods goods = new Goods();
        goods.setGoodsName(goodsName);
        if (priceRefer == null || price == 0) {
            goods.setPriceRefer(price);
        } else {
            goods.setPriceRefer(priceRefer);
        }
        goods.setPrice(price);
        goods.setShId(shId);
        // 默认商品的状态码
        goods.setGoodsEnum(GoodsEnum.NORMAL);
        // 默认销量，库存量
        goods.setSales(0);
        if (goodsStock == null) {
            goodsStock = 0;
        }
        goods.setStock(goodsStock);
        return goods;
    }


    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", shId=" + shId +
                ", sales=" + sales +
                ", priceRefer=" + priceRefer +
                ", price=" + price +
                ", stock=" + stock +
                ", goodsEnum=" + goodsEnum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return Objects.equals(goodsId, goods.goodsId) &&
                Objects.equals(goodsName, goods.goodsName) &&
                Objects.equals(shId, goods.shId) &&
                Objects.equals(sales, goods.sales) &&
                Objects.equals(priceRefer, goods.priceRefer) &&
                Objects.equals(price, goods.price) &&
                Objects.equals(stock, goods.stock) &&
                goodsEnum == goods.goodsEnum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsId, goodsName, shId, sales, priceRefer, price, stock, goodsEnum);
    }

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public GoodsEnum getGoodsEnum() {
        return goodsEnum;
    }

    public void setGoodsEnum(GoodsEnum goodsEnum) {
        this.goodsEnum = goodsEnum;
    }

}