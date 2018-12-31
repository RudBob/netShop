package cn.edu.zzuli.controller.shopper;

import cn.edu.zzuli.NetShopApplication;
import cn.edu.zzuli.controller.user.LoginController;
import cn.edu.zzuli.util.Msg;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.servlet.http.HttpServletRequest;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = NetShopApplication.class)
public class ShopperControllerTest {
    @Autowired
    MockHttpServletRequest request;

    @Autowired
    MockHttpSession session;

    @Autowired
    MockHttpServletResponse response;
    @Autowired
    LoginController loginController;

    @Autowired
    ShopperController shopperController;

    /**
     * 测试之前需要先进行登录操作
     */
    @Before
    public void login() {
//        loginController.login("001001", "123456");
        session.setAttribute("001001","123456");
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