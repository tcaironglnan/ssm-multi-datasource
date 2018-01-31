package com.ssm.dao;

import com.ssm.model.Student;

import java.util.List;

/**
 * 学生实体映射接口
 * @author FaceFeel
 * @Created 2018-01-28 20:31
 */

public interface StudentMapper {

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
