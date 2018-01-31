package com.ssm.service;

import com.ssm.model.Student;

import java.util.List;

/**
 * 获取oracle数据库数据接口
 * @author FaceFeel
 * @Created 2018-01-28 20:30
 */
public interface StudentService {

    /**
     * 按照学生姓名查询数据
     * @param student 学生实体
     * @return 学生实体
     */
    Student findStudentByUserName(Student student);

    /**
     * 获取学生数据列表
     * @return 学生集合
     */
    List<Student> getList();
}
