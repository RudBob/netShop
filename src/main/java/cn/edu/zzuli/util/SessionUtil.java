package cn.edu.zzuli.util;

import cn.edu.zzuli.bean.Shop;
import cn.edu.zzuli.bean.User;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

/**
 * @ClassName SessionUtil
 * @Description 对于Session中的操作，封装起来，因为键值对中的键是String类型，不便于控制，在这里可以隐藏细节。
 * @Author 任耀
 * @Date 2018/12/24 21:00
 * @Version 1.0
 */
public class SessionUtil {
    @Autowired
    private static HttpServletRequest request;

    @Autowired
    private HttpServletRequest request2;


    @PostConstruct
    public void beforeInit() {
        request = request2;
    }

    /**
     * user在session中的名字，也就是键值对的键。
     */
    private static final String USER_NAME_IN_SESSION = "user";
    /**
     * shop在session中的名字，也就是键值对的键。
     */
    private static final String SHOP_NAME_IN_SESSION = "shop";

    /**
     * 从session中获取到当前用户
     *
     * @return
     */
    public static User getUserFromSession() {
        return (User) request.getSession().getAttribute(USER_NAME_IN_SESSION);
    }

    /**
     * 更新Session中的user
     *
     * @param user
     * @return
     */
    public static User updateUserInSession(User user) {
        // 直接放入user，顶替掉原来session中的user
        return putUserIntoSession(user);
    }

    /**
     * 将user放入Session对象中
     *
     * @param user 用户
     * @return
     */
    public static User putUserIntoSession(User user) {
        HttpSession session = request.getSession();
        session.setAttribute(USER_NAME_IN_SESSION, user);
        return getUserFromSession();
    }


    /**
     * 从session中移除User对象
     *
     * @return
     */
    public static User removeUserFromSession() {
        HttpSession session = request.getSession();
        User user = getUserFromSession();
        session.removeAttribute(USER_NAME_IN_SESSION);
        // 移出商店,如果有的话
        if (getShopFromSession() != null) {
            removeShopFromSession();
        }
        return user;
    }

    /**
     * 将shop放入Session对象
     *
     * @param shop 商店
     */
    public static void putShopIntoSession(Shop shop) {
        HttpSession session = request.getSession();
        session.setAttribute(SHOP_NAME_IN_SESSION, shop);
    }

    /**
     * 从session中移除User对象
     *
     * @return
     */
    public static Shop removeShopFromSession() {
        HttpSession session = request.getSession();
        Shop shop = getShopFromSession();
        session.removeAttribute(SHOP_NAME_IN_SESSION);
        return shop;
    }

    /**
     * 从Session中获取到Shop
     *
     * @return 将Session中的Shop返回
     */
    private static Shop getShopFromSession() {
        return (Shop) request.getSession().getAttribute(SHOP_NAME_IN_SESSION);
    }

}
