package cn.imzfz.model.dao;

import cn.imzfz.model.bean.User;

/**
 * Created by zfz on 2017/11/24.
 */
public interface UserDao {
    boolean isValid(User user);
}
