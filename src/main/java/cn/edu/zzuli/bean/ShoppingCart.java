package cn.edu.zzuli.bean;

import java.util.List;

public class ShoppingCart {
    private Integer userId;
    private List<CartDetail> cartDetails;

    public ShoppingCart() {
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "userId=" + userId +
                ", cartDetails=" + cartDetails +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<CartDetail> getCartDetails() {
        return cartDetails;
    }

    public void setCartDetails(List<CartDetail> cartDetails) {
        this.cartDetails = cartDetails;
    }
}
