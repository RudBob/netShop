package cn.edu.zzuli.service.consumer.impl;

import cn.edu.zzuli.bean.*;
import cn.edu.zzuli.mapper.UserOrderMapper;
import cn.edu.zzuli.service.consumer.ConsumerAddrService;
import cn.edu.zzuli.service.order.OrderDataService;
import cn.edu.zzuli.service.order.OrderService;
import cn.edu.zzuli.service.consumer.ConsumerGoodsService;
import cn.edu.zzuli.service.shopper.ShopperService;
import cn.edu.zzuli.service.user.UserMoneyService;
import cn.edu.zzuli.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Service
public class ConsumerGoodsServiceImpl implements ConsumerGoodsService {
    @Autowired
    private UserMoneyService userMoneyService;
    @Autowired
    private OrderService userOrderService;
    @Autowired
    private OrderDataService orderDataService;
    @Autowired
    private ConsumerAddrService consumerAddrService;
    @Autowired
    private ShopperService shopperService;

    /**
     * 用户生成一个订单
     *
     * @param orderDatas 订单的详情
     * @return 返回一个用户订单
     */
    @Override
    @Transactional
    public UserOrder createOrder(OrderData[] orderDatas, Integer addrId) {
        // 生成一张新订单
        // 先得到用户
        int userId = SessionUtil.getUserIdFromSession();
        //得到对应的收货地址对象
        UserAddr userAddr = consumerAddrService.getAddrByAddrId(addrId);
        UserOrder userOrder = UserOrder.userOrderFactory(userId, userAddr);
        // 订单插入数据库
        userOrderService.insertRecord(userOrder);
        int userOrderId = userOrderService.getLastOrderId(userId);
        userOrder.setUoId(userOrderId);
        // 将订单详情插入数据库
        orderDataService.insertRecords(orderDatas, userOrderId);
        userOrder.setOrderDataList(Arrays.asList(orderDatas));
        // 返回订单
        return userOrder;
    }

    /**
     * 为某一个订单付款
     *
     * @param orderId 订单的id
     * @return 将改变状态后的订单返回
     */
    @Override
    public UserOrder payOrder(Integer orderId, String payPwd) {
        UserOrder userOrder = selectUserOrderCascade(orderId);
        // 得到用户
        User user = SessionUtil.getUserFromSession();
        boolean res = userMoneyService.checkPwd(user.getUserId(), payPwd);
        if (!res) {
            return null;
        }
        // 检查用户的余额
        double money = userMoneyService.getUserMoneyByUserId(user.getUserId()).getMoney();
        double allPrice = getAllPrice(userOrder);
        // 钱不够的情况
        if (money < allPrice) {
            return null;
        }
        // 支付金额 使用：先付账，后发货的形式
        payMoneyToShopper(user, userOrder);
        userOrderService.payOrderSuccess(userOrder);
        return userOrder;
    }

    /**
     * 得到订单的总金额
     * 爱你
     *
     * @param userOrder 得到一条订单的总价格
     * @return 返回总价格
     */
    private double getAllPrice(UserOrder userOrder) {
        // 得到订单的详情
        List<OrderData> orderDataList = userOrder.getOrderDataList();
        double allMoney = 0.0;
        // 得到用户的花钱宝
        for (OrderData data : orderDataList) {
            // 得到其中的商品
            double goodsPrice = data.getGoods().getPrice();
            int goodsNum = data.getNum();
            double allPrice = goodsPrice * goodsNum;
            allMoney += allPrice;
        }
        return allMoney;
    }

    /**
     * 封装级联数据库查询
     *
     * @param orderId
     * @return
     */
    private UserOrder selectUserOrderCascade(Integer orderId) {
        UserOrder userOrder = userOrderService.getUserOrderById(orderId);
        List<OrderData> orderDataList = orderDataService.getOrderDataByOrderId(orderId);
        if (orderDataList == null) {
            return null;
        }
        userOrder.setOrderDataList(orderDataList);
        return userOrder;
    }

    /**
     * 将用户的money转到各个店家的余额中
     *
     * @param user      用户
     * @param userOrder 用户订单
     */
    private void payMoneyToShopper(User user, UserOrder userOrder) {
        // 得到订单的详情
        List<OrderData> orderDataList = userOrder.getOrderDataList();
        // 得到用户的花钱宝
        UserMoney userMoney = userMoneyService.getUserMoneyByUserId(user.getUserId());
        for (OrderData data : orderDataList) {
            // 得到其中的商品
            double goodsPrice = data.getGoods().getPrice();
            int goodsNum = data.getNum();
            double allPrice = goodsPrice * goodsNum;
            User shopper = shopperService.getShopperByShopId(data.getGoods().getShId());
            // 此处应该生成一个转账记录，但是我懒T O D O
            userMoneyService.transferMoney(user, shopper, allPrice);
        }
    }


    /**
     * 未来实现
     *
     * @param goodsId 收藏的商品id
     * @return
     */
    @Override
    public int collectGoods(Integer goodsId) {

        return 0;
    }


}
