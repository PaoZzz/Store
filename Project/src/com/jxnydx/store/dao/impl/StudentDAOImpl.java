package com.jxnydx.store.dao.impl;

import com.jxnydx.store.dao.IStudentDAO;
import com.jxnydx.store.vo.Student;
import com.jxnydx.util.dao.AbstractDAOImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class StudentDAOImpl extends AbstractDAOImpl implements IStudentDAO {
    public StudentDAOImpl(Connection conn) {
        super(conn);
    }

    @Override
    public boolean doCreate(Student vo) throws Exception {
        String sql = "INSERT INTO student(sno, spassword, sname, smoney, sstatus, sclass, slocate, sphone) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, vo.getSno());
        super.pstmt.setString(2, vo.getSpassword());
        super.pstmt.setString(3, vo.getSname());
        super.pstmt.setDouble(4, vo.getSmoney());
        super.pstmt.setInt(5, vo.getSstatus());
        super.pstmt.setString(6, vo.getSclass());
        super.pstmt.setString(7, vo.getSlocate());
        super.pstmt.setString(8, vo.getSphone());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdate(Student vo) throws Exception {
        String sql = "UPDATE student SET spassword=?, sname=?, smoney=?, sstatus=?, sclass=?, slocate=?, sphone=? WHERE sno=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, vo.getSpassword());
        super.pstmt.setString(2, vo.getSname());
        super.pstmt.setDouble(3, vo.getSmoney());
        super.pstmt.setInt(4, vo.getSstatus());
        super.pstmt.setString(5, vo.getSclass());
        super.pstmt.setString(6, vo.getSlocate());
        super.pstmt.setString(7, vo.getSphone());
        super.pstmt.setString(8, vo.getSno());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doRemoveBatch(Set<String> ids) throws Exception {
        return super.removeHandle("student", "sno", ids);
    }

    @Override
    public Student findById(String id) throws Exception {
        Student vo = null;
        String sql = "SELECT sno, spassword, sname, smoney, sstatus, sclass, slocate, sphone FROM student WHERE sno=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, id);
        ResultSet rs = super.pstmt.executeQuery();
        if(rs.next()) {
            vo = new Student();
            vo.setSno(rs.getString(1));
            vo.setSpassword(rs.getString(2));
            vo.setSname(rs.getString(3));
            vo.setSmoney(rs.getDouble(4));
            vo.setSstatus(rs.getInt(5));
            vo.setSclass(rs.getString(6));
            vo.setSlocate(rs.getString(7));
            vo.setSphone(rs.getString(8));
        }
        return vo;
    }

    @Override
    public List<Student> findAll() throws Exception {
        List<Student> all = new ArrayList<Student>();
        String sql = "SELECT sno, spassword, sname, smoney, sstatus, sclass, slocate, sphone FROM student";
        super.pstmt = super.conn.prepareStatement(sql);
        ResultSet rs = super.pstmt.executeQuery();
        while(rs.next()) {
            Student vo = new Student();
            vo.setSno(rs.getString(1));
            vo.setSpassword(rs.getString(2));
            vo.setSname(rs.getString(3));
            vo.setSmoney(rs.getDouble(4));
            vo.setSstatus(rs.getInt(5));
            vo.setSclass(rs.getString(6));
            vo.setSlocate(rs.getString(7));
            vo.setSphone(rs.getString(8));
            all.add(vo);
        }
        return all;
    }

    @Override
    public List<Student> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord) throws Exception {
        return null;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws Exception {
        return null;
    }

    @Override
    public boolean findLogin(Student vo) throws Exception {
        String sql = "SELECT sno, sclass FROM student WHERE sno=? AND spassword=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,vo.getSno());
        super.pstmt.setString(2, vo.getSpassword());
        ResultSet rs = super.pstmt.executeQuery();
        if(rs.next()) {
            return true;
        }
        return false;
    }
}
