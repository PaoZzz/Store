package com.jxnydx.store.dao;

import com.jxnydx.store.vo.Student;

public interface IStudentDAO extends IDAO<String, Student> {
    /**
     * 本操作实现管理员的登录功能，在登录完成之后要将上一次的登录时间取出
     * 传递的是vo类的一个对象，所以将登录日期返回到此对象中即可返回
     * @param vo 包含有aid、password的数据对象
     * @return 登录成功返回true、否则返回false
     * @throws Exception
     */
    public boolean findLogin(Student vo) throws Exception;
}
