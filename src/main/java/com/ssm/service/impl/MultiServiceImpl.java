package com.ssm.service.impl;

import com.ssm.dao.StudentMapper;
import com.ssm.dao.UserMapper;
import com.ssm.model.Student;
import com.ssm.model.UserModel;
import com.ssm.service.MultiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 多数据源的接口实现类
 * 使用时，用@Transactional("datasource1Tx")和@Transactional("datasource2Tx")，来区别具体使用某个事务管理器
 * 或者，直接使用transactionManager 的bean名字：@Transactional("transactionManager1")
 * 如果是使用@Transactional()，相当于使用缺省的transactionManager名字，即：@Transactional("transactionManager")
 * @author FaceFeel
 * @Created 2018-01-29 13:56
 */
@Service("multiService")
public class MultiServiceImpl implements MultiService {

    /**
     * oracle数据库表映射
     */
    @Autowired
    private StudentMapper studentMapper;
    /**
     * mysql数据库标映射
     */
    @Autowired
    private UserMapper userMapper;

    /**
     * 获取oracle数据库数据列表
     * @return 集合
     */
    @Override
    public List<Student> showOracle() {
        return studentMapper.getList();
    }

    /**
     * 获取mysql数据库数据列表
     * @return 集合
     */
    @Override
    public List<UserModel> showMysql() {
        return userMapper.getList();
    }
}
