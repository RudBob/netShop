package cn.edu.zzuli.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName MD5Util
 * @Description MD5工具类
 * @Author 任耀
 * @Date 2018/12/24 10:08
 * @Version 1.0
 */
public class MD5Util {
    public static void main(String[] args) {
        System.out.println(md5Pwd("123456"));
    }
    public static String md5Pwd(String password) {
        try { // 得到一个信息摘要器
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(password.getBytes());
            StringBuilder buffer = new StringBuilder();
            // 把每一个byte 做一个与运算 0xff;
            for (byte b : result) { // 与运算
                int number = b & 0xff;// 加盐
                String str = Integer.toHexString(number);
                if (str.length() == 1) {
                    buffer.append("0");
                }
                buffer.append(str);
            }
            return buffer.toString();
        } catch (
                NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }
}

