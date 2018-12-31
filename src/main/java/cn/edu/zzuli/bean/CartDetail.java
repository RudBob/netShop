package cn.edu.zzuli.bean;

public class CartDetail {
    private Integer userId;

    private Goods goods;

    private Integer num;

    public static CartDetail shoppingCartFactory(Integer userId, Goods goods) {
        int num = 1;
        return shoppingCartFactory(userId, goods, num);
    }

    public static CartDetail shoppingCartFactory(Integer userId, Goods goods, Integer num) {
        CartDetail detail = new CartDetail();
        detail.setGoods(goods);
        detail.setUserId(userId);
        detail.setNum(num);
        return detail;
    }

    public CartDetail() {
    }

    public CartDetail(Integer userId, Goods goods, Integer num) {
        this.userId = userId;
        this.goods = goods;
        this.num = num;
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