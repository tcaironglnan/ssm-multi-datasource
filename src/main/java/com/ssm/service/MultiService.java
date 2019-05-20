package com.ssm.service;

import com.ssm.config.predefined.DataSource;
import com.ssm.model.Student;
import com.ssm.model.UserModel;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 针对使用的数据库进行注解
 * 使用时，用@Transactional("datasource1Tx")和@Transactional("datasource2Tx")，
 * 事务的名字在配置文件中配置，来区别具体使用某个事务管理器或者，
 * 直接使用transactionManager 的bean名字：@Transactional("transactionManager1")
 * 如果是使用@Transactional()，相当于使用缺省的transactionManager名字，
 * 即：@Transactional("transactionManager")
 * @author FaceFeel
 * @Created 2018-01-29 13:52
 */
public interface MultiService {

    /**
     * 使用mysql数据库，注解值就是需要切换的数据库数据源key
     * 因为默认是使用oracle数据库，所以也是用默认的事务，也可以指定
     * @return 集合
     */
    @DataSource("master")
    //@Transactional("transactionManager_oracle")
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    List<Student> showOracle();

    /**
     * 使用oracle数据库，注解值就是需要切换的数据库数据源key
     * 并且使用的是mysql数据库的事务
     * @return 集合
     */
    @DataSource("slave")
    @Transactional("transactionManager_mysql")
    //@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    List<UserModel> showMysql();
}
