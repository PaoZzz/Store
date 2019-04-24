package com.jxnydx.store.service.back.impl;


import com.jxnydx.store.dbc.DatabaseConnection;
import com.jxnydx.store.factory.DAOFactory;
import com.jxnydx.store.service.back.IMerchantServiceBack;
import com.jxnydx.store.vo.Merchant;

import java.util.List;
import java.util.Set;

public class MerchantServiceBackImpl implements IMerchantServiceBack{
    private DatabaseConnection dbc = new DatabaseConnection();

    @Override
    public boolean insert(Merchant vo) throws Exception {
        try {
            return DAOFactory.getIMerchantDAOInstance(this.dbc.getConnection()).doCreate(vo);
        } catch(Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public boolean update(Merchant vo) throws Exception {
        try {
            return DAOFactory.getIMerchantDAOInstance(this.dbc.getConnection()).doUpdate(vo);
        } catch(Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public boolean delete(Set<String> ids) throws Exception {
        try {
            return DAOFactory.getIMerchantDAOInstance(this.dbc.getConnection()).doRemoveBatch(ids);
        } catch(Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public List<Merchant> list() throws Exception {
        try {
            return DAOFactory.getIMerchantDAOInstance(this.dbc.getConnection()).findAll();
        } catch(Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public Merchant getMerchantInfo(String id) throws Exception {
        try {
            return DAOFactory.getIMerchantDAOInstance(this.dbc.getConnection()).findById(id);
        } catch(Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }
}
