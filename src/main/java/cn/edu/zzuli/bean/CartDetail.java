package cn.edu.zzuli.bean;

public class CartDetail {
    private Integer detailId;

    private Integer userId;

    private Goods goods;

    private Integer num;

    public static CartDetail shoppingCartFactory(Integer userId, Goods goods, Integer num) {
        CartDetail cartDetail = new CartDetail();
        cartDetail.setUserId(userId);
        cartDetail.setGoods(goods);
        cartDetail.setNum(num);
        return cartDetail;
    }

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}