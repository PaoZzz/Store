package com.jxnydx.store.service.back.impl;

import com.jxnydx.store.dbc.DatabaseConnection;
import com.jxnydx.store.factory.DAOFactory;
import com.jxnydx.store.service.back.IGoodsServiceBack;
import com.jxnydx.store.vo.Goods;
import com.jxnydx.store.vo.Merchant;

import java.util.List;
import java.util.Set;

public class GoodsServiceBackImpl implements IGoodsServiceBack{
    private DatabaseConnection dbc = new DatabaseConnection();

    @Override
    public boolean insert(Goods vo) throws Exception {
        try {
            return DAOFactory.getIGoodsDAOInstance(this.dbc.getConnection()).doCreate(vo);
        } catch(Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public boolean update(Goods vo) throws Exception {
        try {
            return DAOFactory.getIGoodsDAOInstance(this.dbc.getConnection()).doUpdate(vo);
        } catch(Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public boolean delete(Set<Integer> ids) throws Exception {
        try {
            return DAOFactory.getIGoodsDAOInstance(this.dbc.getConnection()).doRemoveBatch(ids);
        } catch(Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public List<Goods> list() throws Exception {
        try {
            return DAOFactory.getIGoodsDAOInstance(this.dbc.getConnection()).findAll();
        } catch(Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public Merchant findMerchant(Goods vo) throws Exception {
        return null;    // Waitting me do it.
    }
}
