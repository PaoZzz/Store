package com.jxnydx.store.service.front.impl;

import com.jxnydx.store.dbc.DatabaseConnection;
import com.jxnydx.store.factory.DAOFactory;
import com.jxnydx.store.service.front.IStudentServiceFront;
import com.jxnydx.store.vo.Merchant;
import com.jxnydx.store.vo.Student;

import java.util.List;

public class StudentServiceFrontImpl implements IStudentServiceFront{
    private DatabaseConnection dbc = new DatabaseConnection();

    @Override
    public boolean login(Student vo) throws Exception {
        try {
            return DAOFactory.getIStudentDAOInstance(this.dbc.getConnection()).findLogin(vo);
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

    @Override
    public Merchant getMerchantInfo(String name) throws Exception {
        try {
            return DAOFactory.getIMerchantDAOInstance(this.dbc.getConnection()).findByName(name);
        } catch(Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public List<Merchant> getAllMerchant() throws Exception {
        try {
            return DAOFactory.getIMerchantDAOInstance(this.dbc.getConnection()).findAll();
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
}
