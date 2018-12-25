package cn.edu.zzuli.controller.shopper;

import cn.edu.zzuli.BlogApplication;
import cn.edu.zzuli.controller.user.LoginController;
import cn.edu.zzuli.util.Msg;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.servlet.http.HttpServletRequest;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = BlogApplication.class)
public class ShopperControllerTest {
    @Autowired
    LoginController loginController;
    @Autowired
    HttpServletRequest request;

    @Autowired
    ShopperController shopperController;

    /**
     * 测试之前需要先进行登录操作
     */
    @Before
    public void login() {
        loginController.login("001001", "123456");
        System.out.println("登录成功");
    }

    @Test
    public void weatherCanBecomeShopper() {
        String prefix = "用户是否有资格成为一个店主？:";
        Msg msg = shopperController.weatherCanBecomeShopper();
        System.out.println(prefix + msg.isSuccess());
    }

    @Test
    public void becomeShopper() {
        String prefix = "用户成为了一个店主吗:";
        Msg msg = shopperController.becomeShopper("newShopName");
        System.out.println(prefix + msg.isSuccess());
    }
}