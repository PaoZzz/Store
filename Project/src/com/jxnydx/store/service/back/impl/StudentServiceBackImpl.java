package com.jxnydx.store.service.back.impl;

import com.jxnydx.store.dbc.DatabaseConnection;
import com.jxnydx.store.factory.DAOFactory;
import com.jxnydx.store.service.back.IStudentServiceBack;
import com.jxnydx.store.vo.Student;

import java.util.List;
import java.util.Set;

public class StudentServiceBackImpl implements IStudentServiceBack{
    private DatabaseConnection dbc = new DatabaseConnection();

    @Override
    public boolean insert(Student vo) throws Exception {
        try {
            return DAOFactory.getIStudentDAOInstance(this.dbc.getConnection()).doCreate(vo);
        } catch(Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public boolean update(Student vo) throws Exception {
        try {
            return DAOFactory.getIStudentDAOInstance(this.dbc.getConnection()).doUpdate(vo);
        } catch(Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public boolean delete(Set<String> ids) throws Exception {
        try {
            return DAOFactory.getIStudentDAOInstance(this.dbc.getConnection()).doRemoveBatch(ids);
        } catch(Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public List<Student> list() throws Exception {
        try {
            return DAOFactory.getIStudentDAOInstance(this.dbc.getConnection()).findAll();
        } catch(Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public Student getStudentInfo(String id) throws Exception {
        try {
            return DAOFactory.getIStudentDAOInstance(this.dbc.getConnection()).findById(id);
        } catch(Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }
}
