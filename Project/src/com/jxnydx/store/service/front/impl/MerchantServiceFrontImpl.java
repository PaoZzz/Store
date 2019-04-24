package com.jxnydx.store.service.front.impl;

import com.jxnydx.store.dbc.DatabaseConnection;
import com.jxnydx.store.factory.DAOFactory;
import com.jxnydx.store.service.front.IMerchantServiceFront;
import com.jxnydx.store.vo.Merchant;

public class MerchantServiceFrontImpl implements IMerchantServiceFront {
    private DatabaseConnection dbc = new DatabaseConnection();

    @Override
    public boolean login(Merchant vo) throws Exception {
        try {
            return DAOFactory.getIMerchantDAOInstance(this.dbc.getConnection()).findLogin(vo);
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
}
