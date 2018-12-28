package cn.edu.zzuli.bean;

public class ShoppingCart {
    private Integer cartId;

    private Goods goods;

    private Integer userId;

    private Integer num;

    public ShoppingCart() {
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "cartId=" + cartId +
                ", goods=" + goods +
                ", userId=" + userId +
                ", num=" + num +
                '}';
    }

    public static ShoppingCart shoppingCartFactory(Goods goods, Integer userId) {
        // 默认加入购物车的数量为1个。
        int num = 1;
        return shoppingCartFactory(goods, userId, num);
    }

    public static ShoppingCart shoppingCartFactory(Goods goods, Integer userId, Integer num) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setGoods(goods);
        shoppingCart.setUserId(userId);
        shoppingCart.setNum(num);
        return shoppingCart;
    }

    public ShoppingCart(Integer cartId, Goods goods, Integer userId, Integer num) {
        this.cartId = cartId;
        this.goods = goods;
        this.userId = userId;
        this.num = num;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

}