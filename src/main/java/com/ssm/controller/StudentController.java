package com.ssm.controller;

import com.ssm.model.Student;
import com.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取oracle数据库数据测试类
 * @author FaceFeel
 * @Created 2018-01-28 20:29
 */

@Controller
@RequestMapping("/student")
public class StudentController {

    /**
     * 获取mysql数据库数据接口
     */
    @Autowired
    private StudentService studentService;

    /**
     * 按照学生姓名查询
     * @param request 请求
     * @return jsp页面名称
     */
    @RequestMapping("/show")
    public String showStudent(HttpServletRequest request){
        request.setAttribute("user",studentService.findStudentByUserName(new Student().setSname("曹操")));
        return "success";
    }

    /**
     * 获取学生数据列表
     * @param request 请求
     * @return jsp页面名称
     */
    @RequestMapping("/list")
    public String showList(HttpServletRequest request){
        request.setAttribute("listOracle",studentService.getList());
        return "showList";
    }
}
