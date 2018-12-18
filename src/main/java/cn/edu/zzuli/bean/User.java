package cn.edu.zzuli.bean;

import java.util.Objects;

public class User {
    /**
     * 用户编号
     */
    private int userId;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户密码
     */
    private String pwd;

    public User() {
    }

    public User(int userId, String userName, String password) {
        this.userId = userId;
        this.userName = userName;
        this.pwd = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(pwd, user.pwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, pwd);
    }
}
