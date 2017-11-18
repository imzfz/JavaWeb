package cn.imzfz.faq;

/**
 * Created by zfz on 2017/10/16.
 * 本类用于检查用户名密码是否合法
 */
public class Check {
    private String user;
    private String pass;

    public Check(){

    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isValid(){
        if(user.equals("zhangfangzi") && pass.equals("2015011379")){
            return true;
        }
        return false;
    }
}
