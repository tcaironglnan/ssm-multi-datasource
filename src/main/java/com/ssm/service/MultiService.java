package com.ssm.service;

import com.ssm.config.predefined.DataSource;
import com.ssm.model.Student;
import com.ssm.model.UserModel;

import java.util.List;

/**
 * 针对使用的数据库进行注解
 * @author FaceFeel
 * @Created 2018-01-29 13:52
 */
public interface MultiService {

    /**
     * 使用mysql数据库，注解值就是需要切换的数据库数据源key
     * @return 集合
     */
    @DataSource("master")
    List<Student> showOracle();

    /**
     * 使用oracle数据库，注解值就是需要切换的数据库数据源key
     * @return 集合
     */
    @DataSource("slave")
    List<UserModel> showMysql();
}
