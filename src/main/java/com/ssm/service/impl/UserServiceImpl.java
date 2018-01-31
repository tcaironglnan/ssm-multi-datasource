package com.ssm.service.impl;

import com.ssm.dao.UserMapper;
import com.ssm.model.UserModel;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 获取mysql数据库接口实现类
 * @author FaceFeel
 * @Created 2018-01-28 19:48
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    /**
     * 用户实体映射接口
     */
    @Autowired
    private UserMapper userMapper;

    /**
     * 按照用户姓名查询数据，传入参数最好使用字符串
     * @param userModel 用户实体
     * @return 用户实体
     */
    @Override
    public UserModel findUserByUserName(UserModel userModel) {
        return userMapper.findUserByUserName(userModel);
    }
}
