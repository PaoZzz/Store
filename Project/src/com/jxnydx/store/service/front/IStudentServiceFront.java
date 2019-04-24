package com.jxnydx.store.service.front;

import com.jxnydx.store.vo.Merchant;
import com.jxnydx.store.vo.Student;

import java.util.List;

public interface IStudentServiceFront {
    /**
     * 用户登录操作，调用的是IStudentDAO.findByLogin()方法
     * @param vo 包含有mid与password的member对象
     * @return 登录成功返回true，否则返回false
     * @throws Exception
     */
    public boolean login(Student vo) throws Exception;
    /**
     * 通过输入的数据获取出学生的全部信息
     * @param id 用于查询的学生信息
     * @return 返回一个学生类对象
     * @throws Exception SQL Exception
     */
    public Student getStudentInfo(String id) throws Exception;
    /**
     * There is a method that using name of Merchant to acquire perfect Merchant information.
     * @param name Merchant's name
     * @return  Merchant Object
     * @throws Exception SQL Exception
     */
    public Merchant getMerchantInfo(String name) throws Exception;
    /**
     * The method is used to acquire all Merchant of school.
     * @return List Object of merchant
     * @throws Exception SQL Exception
     */
    public List<Merchant> getAllMerchant() throws Exception;
    /**
     * Relizing informations of Student, including password, locate and phone, are changed.
     * @param vo Need to update, Object of Student
     * @return If come true, will return true, else false.
     * @throws Exception SQL Exception
     */
    public boolean update(Student vo) throws Exception;

}
