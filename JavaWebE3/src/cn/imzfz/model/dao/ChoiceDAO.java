package cn.imzfz.model.dao;

import cn.imzfz.model.bean.Question;
import cn.imzfz.model.bean.Select;
import cn.imzfz.model.bean.TrueOrFalse;
import cn.imzfz.model.impl.ChoiceList;

import java.util.Map;

/**
 * Created by zfz on 2017/11/16.
 */
public interface ChoiceDAO {
    void initChoice();
    Map<String, Object> getList();
    boolean addChoice(Question question, Select select);
    boolean addChoice(Question question, TrueOrFalse trueOrFalse);
    boolean delChoice(int id);
    boolean updateChoice(int id);
}
