package cn.edu.zzuli.bean;

/**
 * 订单中的详情数据
 */
public class OrderData {
    private Integer goodsOrderId;

    private Integer goodsId;

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
                ", goodsId=" + goodsId +
                ", goodsPrice=" + goodsPrice +
                ", uoId=" + uoId +
                '}';
    }

    public Integer getGoodsOrderId() {
        return goodsOrderId;
    }

    public void setGoodsOrderId(Integer goodsOrderId) {
        this.goodsOrderId = goodsOrderId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
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