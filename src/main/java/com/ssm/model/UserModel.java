package com.ssm.model;

import com.google.common.base.MoreObjects;
import java.io.Serializable;

/**
 * 用户实体
 * @author FaceFeel
 * @Created 2018-01-28 19:44
 */

public class UserModel implements Serializable{
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String passWord;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("userName", userName)
                .add("passWord", passWord)
                .toString();
    }

    public String getUserName() {
        return userName;
    }

    public UserModel setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassWord() {
        return passWord;
    }

    public UserModel setPassWord(String passWord) {
        this.passWord = passWord;
        return this;
    }
}
