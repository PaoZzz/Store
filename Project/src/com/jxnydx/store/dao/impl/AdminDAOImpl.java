package com.jxnydx.store.dao.impl;

import com.jxnydx.store.vo.Admin;
import com.jxnydx.store.dao.IAdminDAO;
import com.jxnydx.util.dao.AbstractDAOImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

public class AdminDAOImpl extends AbstractDAOImpl implements IAdminDAO {

	public AdminDAOImpl(Connection conn) {
		super(conn);
	}

	@Override
	public boolean doCreate(Admin vo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(Admin vo) throws Exception {
		String sql = "UPDATE admin SET password=? WHERE aid=?";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1, vo.getPassword());
		super.pstmt.setString(2, vo.getAid());
		return super.pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean doRemoveBatch(Set<String> ids) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Admin findById(String id) throws Exception {
		String sql = "SELECT aid, password FROM admin WHERE aid=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, id);
		ResultSet rs = this.pstmt.executeQuery();
		Admin vo = null;
		if (rs.next()) {
			vo = new Admin();
			vo.setAid(rs.getString(1));
			vo.setPassword(rs.getString(2));
			return vo;
		}
		return vo;
	}

	@Override
	public List<Admin> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Admin> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAllCount(String column, String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean findLogin(Admin vo) throws Exception {
		String sql = "SELECT lastdate FROM admin WHERE aid=? AND password=?";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1,vo.getAid());
		super.pstmt.setString(2, vo.getPassword());
		ResultSet rs = super.pstmt.executeQuery();
		if(rs.next()) {
			vo.setLastdate(rs.getTimestamp(1));
			return true;
		}
		return false;
	}

	@Override
	public boolean doUpdateLastdate(String aid) throws Exception {
		String sql = "UPDATE admin SET lastdate=? WHERE aid=?";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setTimestamp(1, new Timestamp(new java.util.Date().getTime()));
		super.pstmt.setString(2, aid);
		return super.pstmt.executeUpdate() > 0;
	}
}
