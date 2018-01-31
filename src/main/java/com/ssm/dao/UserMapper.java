package com.ssm.dao;

import com.ssm.model.UserModel;

import java.util.List;

/**
 * 用户实体映射接口
 * @author FaceFeel
 * @Created 2018-01-28 19:50
 */

public interface UserMapper {

    /**
     * 按照用户姓名查询数据，传入参数最好使用字符串
     * @param userModel 用户实体
     * @return 用户实体
     */
    UserModel findUserByUserName(UserModel userModel);

    /**
     * 获取用户数据列表
     * @return 用户集合
     */
    List<UserModel> getList();
}
