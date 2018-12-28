package cn.edu.zzuli.util.connection_util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * @ClassName EmailUtil
 * @Description 用户邮箱的帮助类
 * @Author 任耀
 * @Date 2018/12/22 21:21
 * @Version 1.0
 */
public class EmailUtil {
    // 发件人 账号和密码
    /**
     * 发送邮箱：17630065958@163.com
     */
    private static final String MY_EMAIL_ACCOUNT = "17630065958@163.com";
    /**
     * 授权码：renyao123456
     */
    private static final String MY_EMAIL_PASSWORD = "renyao123456";// 密码,是你自己的设置的授权码

    // SMTP服务器(这里用的163 SMTP服务器)
    /**
     * 163代理服务器
     */
    private static final String MEAIL_163_SMTP_HOST = "smtp.163.com";
    /**
     * 163 使用的端口
     */
    private static final String SMTP_163_PORT = "25";// 端口号,这个是163使用到的;QQ的应该是465或者875

    /**
     * @param targetAddr 目标邮箱地址
     * @param code       验证码
     */
    public static void sendMail(String targetAddr, String code) {
        Properties p = new Properties();
        p.setProperty("mail.smtp.host", MEAIL_163_SMTP_HOST);
        p.setProperty("mail.smtp.port", SMTP_163_PORT);
        p.setProperty("mail.smtp.socketFactory.port", SMTP_163_PORT);
        p.setProperty("mail.smtp.auth", "true");
        p.setProperty("mail.smtp.socketFactory.class", "SSL_FACTORY");

        Session session = Session.getInstance(p, new Authenticator() {
            // 设置认证账户信息
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(MY_EMAIL_ACCOUNT, MY_EMAIL_PASSWORD);
            }
        });
//        session.setDebug(true);
        MimeMessage message = new MimeMessage(session);
        try {
            // 发件人
            message.setFrom(new InternetAddress(MY_EMAIL_ACCOUNT));
            // 收件人和抄送人
            message.setRecipients(Message.RecipientType.TO, targetAddr);

            // 内容(这个内容还不能乱写,有可能会被SMTP拒绝掉;多试几次吧)
            message.setSubject("博客注册验证码");
            message.setContent("您的验证码为 : <h1>" + code+"</h1>", "text/html;charset=UTF-8");
            message.setSentDate(new Date());
            message.saveChanges();
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
