package com.jxnydx.store.service.back;

import com.jxnydx.store.vo.Student;

import java.util.List;
import java.util.Set;

public interface IStudentServiceBack {
    public boolean insert(Student vo) throws Exception;
    public boolean update(Student vo) throws Exception;
    public boolean delete(Set<String> ids) throws Exception;
    public List<Student> list() throws Exception;
    /**
     * 通过输入的数据获取出学生的全部信息
     * @param id 用于查询的学生信息
     * @return 返回一个学生类对象
     * @throws Exception SQL Exception
     */
    public Student getStudentInfo(String id) throws Exception;
}
