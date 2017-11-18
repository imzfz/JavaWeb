package cn.imzfz.model.bean;

/**
 * Created by zfz on 2017/11/13.
 */
public class Check{
    private String user;
    private String pass;
    public Check(String user, String pass){
        this.user = user;
        this.pass = pass;
    }

    public boolean isValid(){
        if(user.equals("zfz") && pass.equals("123")){
            return true;
        }
        return false;
    }
}
