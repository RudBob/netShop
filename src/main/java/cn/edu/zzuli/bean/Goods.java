package cn.edu.zzuli.bean;

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

    public Goods() {
    }

    public static Goods goodsFactory(String goodsName, Double priceRefer, Double price, Integer shId) {
        Goods goods = new Goods();
        goods.setGoodsName(goodsName);
        goods.setPriceRefer(priceRefer);
        goods.setPrice(price);
        goods.setShId(shId);

        return goods;
    }

    public static Goods goodsFactory(String goodsName, Double price, Integer shId) {
        return goodsFactory(goodsName, price, price, shId);
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
}