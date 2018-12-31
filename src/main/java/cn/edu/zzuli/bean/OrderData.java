package cn.edu.zzuli.bean;

/**
 * 订单中的详情数据
 */
public class OrderData {
    private Integer goodsOrderId;

    private Goods goods;

    private Integer num;

    private Double goodsPrice;
    /**
     * 订单的id
     */
    private Integer uoId;

    public OrderData() {
    }

    @Override
    public String toString() {
        return "OrderData{" +
                "goodsOrderId=" + goodsOrderId +
                ", goods=" + goods +
                ", num=" + num +
                ", goodsPrice=" + goodsPrice +
                ", uoId=" + uoId +
                '}';
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getGoodsOrderId() {
        return goodsOrderId;
    }

    public void setGoodsOrderId(Integer goodsOrderId) {
        this.goodsOrderId = goodsOrderId;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getUoId() {
        return uoId;
    }

    public void setUoId(Integer uoId) {
        this.uoId = uoId;
    }
}