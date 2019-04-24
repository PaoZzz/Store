package com.jxnydx.store.service.front.impl;

import com.jxnydx.store.dbc.DatabaseConnection;
import com.jxnydx.store.factory.DAOFactory;
import com.jxnydx.store.service.front.IOrdersServiceFront;
import com.jxnydx.store.vo.Orders;

import java.util.List;

public class OrdersServiceFrontImpl implements IOrdersServiceFront {
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
    public List<Orders> listStudentOrders(String sno) throws Exception {
        return null;
    }

    @Override
    public List<Orders> listMerchantOrders(String mid) throws Exception {
        return null;
    }

    @Override
    public boolean updateStatus(Integer oid, Integer status) throws Exception {
        try {
            return DAOFactory.getIOrdersDAOInstance(this.dbc.getConnection()).updateStatus(oid, status);
        } catch(Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public List<Orders> getStudentAllOrders(String sno) throws Exception {
        try {
            return DAOFactory.getIOrdersDAOInstance(this.dbc.getConnection()).findStudentAllOrders(sno);
        } catch(Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public List<Orders> getMerchantAllOrders(String mid) throws Exception {
        try {
            return DAOFactory.getIOrdersDAOInstance(this.dbc.getConnection()).findMerchantAllOrders(mid);
        } catch(Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }
}
