package cn.edu.zzuli.controller;

import cn.edu.zzuli.BlogApplication;
import cn.edu.zzuli.bean.User;
import cn.edu.zzuli.util.Msg;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BlogApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoginControllerTest {

    @Autowired
    LoginController loginController;

    @Test
    public void login() {
//        Msg msg = loginController.login("001001", "123456");
//        System.out.println(msg);
    }

    @Test
    public void logout() {
    }
}