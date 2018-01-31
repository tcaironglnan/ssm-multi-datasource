package com.ssm.service;

import com.ssm.model.UserModel;
import org.springframework.stereotype.Repository;

/**
 * 获取mysql数据库接口
 * @author FaceFeel
 * @Created 2018-01-28 19:44
 */
@Repository
public interface UserService {

    /**
     * 按照用户姓名查询数据，传入参数最好使用字符串
     * @param userModel 用户实体
     * @return 用户实体
     */
    UserModel findUserByUserName(UserModel userModel);
}
