package com.ssm.controller;
import com.ssm.model.UserModel;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取mysql数据库数据测试类
 * @author FaceFeel
 * @Created 2018-01-28 19:12
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 获取mysql数据库数据接口
     */
    @Autowired
    private UserService userService;

    @RequestMapping("/show")
    public String showUser(HttpServletRequest request, HttpServletResponse response){
        request.setAttribute("user",userService.findUserByUserName(new UserModel().setUserName("smith")));
        return "success";
    }
}
