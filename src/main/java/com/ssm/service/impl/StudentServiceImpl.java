package com.ssm.service.impl;

import com.ssm.dao.StudentMapper;
import com.ssm.model.Student;
import com.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author FaceFeel
 * @Created 2018-01-28 20:32
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {

    /**
     * 学生实体映射接口
     */
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 按照学生姓名查询数据
     * @param student 学生实体
     * @return 学生实体
     */
    @Override
    public Student findStudentByUserName(Student student) {
        return studentMapper.findStudentByUserName(student);
    }

    /**
     * 获取学生数据列表
     * @return 学生集合
     */
    @Override
    public List<Student> getList() {
        return studentMapper.getList();
    }
}
