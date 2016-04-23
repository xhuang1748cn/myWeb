package cn.srn.repositories.entity.entities;

import java.sql.Timestamp;

/**
 * Created by Winter on 2016/4/22.
 */
public class User extends Entity {

    private Long uid;
    private String userName;
    private String pwd;
    private Integer vip;
    private Timestamp regtime;

    public User() {
    }

    public Timestamp getRegtime() {
        return regtime;
    }

    public void setRegtime(Timestamp regtime) {
        this.regtime = regtime;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
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

    public Integer getVip() {
        return vip;
    }

    public void setVip(Integer vip) {
        this.vip = vip;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", userName='" + userName + '\'' +
                ", pwd='" + pwd + '\'' +
                ", vip=" + vip +
                ", regtime=" + regtime +
                '}';
    }
}
