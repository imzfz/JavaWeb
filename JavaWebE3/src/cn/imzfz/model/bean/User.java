package cn.imzfz.model.bean;

/**
 * Created by zfz on 2017/11/24.
 */
public class User {
    private String username = "";
    private String pass = "";
    private int auth = 0;

    public User(String username, String pass) {
        this.username = username;
        this.pass = pass;
    }

    public String getUsername() {
        return username;
    }

    public String getPass() {
        return pass;
    }

    public int getAuth() {
        return auth;
    }

    public void setAuth(int auth) {
        this.auth = auth;
    }
}
