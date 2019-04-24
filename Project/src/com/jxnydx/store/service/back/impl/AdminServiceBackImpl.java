package com.jxnydx.store.service.back.impl;



import com.jxnydx.store.factory.DAOFactory;
import com.jxnydx.store.vo.Admin;
import com.jxnydx.store.dbc.DatabaseConnection;
import com.jxnydx.store.service.back.IAdminServiceBack;

public class AdminServiceBackImpl implements IAdminServiceBack {
	private DatabaseConnection dbc = new DatabaseConnection();

	@Override
	public boolean login(Admin vo) throws Exception {
		try {
			if(DAOFactory.getIAdminDAOInstance(this.dbc.getConnection()).findLogin(vo)) {
				return DAOFactory.getIAdminDAOInstance(this.dbc.getConnection()).doUpdateLastdate(vo.getAid());
			}
			return false;
		} catch(Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	@Override
	public Admin getAdminInfo(String id) throws Exception {
		try {
			return DAOFactory.getIAdminDAOInstance(this.dbc.getConnection()).findById(id);
		} catch(Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	@Override
	public boolean update(Admin vo) throws Exception {
		try {
			return DAOFactory.getIAdminDAOInstance(this.dbc.getConnection()).doUpdate(vo);
		} catch(Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}
}
