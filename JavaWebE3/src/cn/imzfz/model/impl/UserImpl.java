package cn.imzfz.model.impl;

import cn.imzfz.model.bean.User;
import cn.imzfz.model.dao.DBConnection;
import cn.imzfz.model.dao.UserDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by zfz on 2017/11/24.
 */
public class UserImpl implements UserDao {

    private static final String TABLE = "Users";

    @Override
    public boolean isValid(User user) {
        Connection connection;
        Statement statement;
        try {
            connection = new DBConnection().connection();
            statement = connection.createStatement();
            ResultSet res = statement.
                    executeQuery("SELECT * from " + TABLE + " WHERE user_name = '" + user.getUsername() + "'");
            while (res.next()) {
                if (res.getString(2).equals(user.getUsername()) && res.getString(3).equals(user.getPass())) {
                    user.setAuth(res.getInt(4));
                    return true;
                }
            }
            System.out.println("check");
            res.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
