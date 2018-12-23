package cn.edu.zzuli.bean;

import cn.edu.zzuli.util.userDataSetting.UserRoleEnum;
import cn.edu.zzuli.util.userDataSetting.UserStateEnum;

import java.util.Objects;

public class User {
    /**
     * 用户编号
     */
    private Integer userId;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户密码
     */
    private String pwd;
    /**
     * 用户手机号
     */
    private String tel;
    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户状态
     */
    private UserStateEnum state;

    /**
     * 用户角色
     */
    private UserRoleEnum role;

    /**
     * 用户头像
     */
    private String headPortrait;


    public User() {
    }

    public static User getNewUserByEmail(String email, String pwd, String userName) {
        User user = new User();
        user.setUserName(userName);
        user.setEmail(email);
        user.setPwd(pwd);
        user.setRole(UserRoleEnum.CONSUMER);
        user.setState(UserStateEnum.NO_CONFIRM);
        return user;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    public UserRoleEnum getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = UserRoleEnum.getStateByNum(role);
    }

    public void setState(UserStateEnum state) {
        this.state = state;
    }

    public void setRole(UserRoleEnum role) {
        this.role = role;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public UserStateEnum getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = UserStateEnum.getStateByNum(state);
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
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
