package cn.edu.zzuli.controller;

import cn.edu.zzuli.BlogApplication;
import cn.edu.zzuli.bean.User;
import cn.edu.zzuli.controller.user.LoginController;
import cn.edu.zzuli.util.Msg;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = BlogApplication.class)
public class LoginControllerTest {

    @Autowired
    LoginController loginController;
    @Autowired
    HttpServletRequest request;

    @Test
    public void testLogin() {
        Msg msg = (Msg) loginController.login("001001", "123456");
        System.out.println(msg);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        System.out.println(user);
    }

    @Test
    public void logout() {

    }
}