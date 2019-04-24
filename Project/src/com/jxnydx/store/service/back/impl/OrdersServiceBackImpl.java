package com.jxnydx.store.service.back.impl;

import com.jxnydx.store.dbc.DatabaseConnection;
import com.jxnydx.store.factory.DAOFactory;
import com.jxnydx.store.service.back.IOrdersServiceBack;
import com.jxnydx.store.vo.Orders;

import java.util.List;
import java.util.Set;

public class OrdersServiceBackImpl implements IOrdersServiceBack {
    private DatabaseConnection dbc = new DatabaseConnection();

    @Override
    public boolean insert(Orders vo) throws Exception {
        try {
            return DAOFactory.getIOrdersDAOInstance(this.dbc.getConnection()).doCreate(vo);
        } catch(Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public boolean update(Orders vo) throws Exception {
        try {
            return DAOFactory.getIOrdersDAOInstance(this.dbc.getConnection()).doUpdate(vo);
        } catch(Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public boolean delete(Set<Integer> ids) throws Exception {
        try {
            return DAOFactory.getIOrdersDAOInstance(this.dbc.getConnection()).doRemoveBatch(ids);
        } catch(Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public List<Orders> list() throws Exception {
        try {
            return DAOFactory.getIOrdersDAOInstance(this.dbc.getConnection()).findAll();
        } catch(Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public boolean updateStatus(Orders vo) throws Exception {
        return false; //Writing me do it.
    }
}
