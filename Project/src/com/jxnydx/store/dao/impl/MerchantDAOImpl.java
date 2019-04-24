package com.jxnydx.store.dao.impl;

import com.jxnydx.store.dao.IMerchantDAO;
import com.jxnydx.store.vo.Merchant;
import com.jxnydx.util.dao.AbstractDAOImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MerchantDAOImpl extends AbstractDAOImpl implements IMerchantDAO {
    public MerchantDAOImpl(Connection conn) {
        super(conn);
    }

    @Override
    public boolean doCreate(Merchant vo) throws Exception {
        String sql = "INSERT INTO merchant(mid, mpassword, mname, mmoney, mstatus, mlocate, mphone) VALUES(?, ?, ?, ?, ?, ?, ?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, vo.getMid());
        super.pstmt.setString(2, vo.getMpassword());
        super.pstmt.setString(3, vo.getMname());
        super.pstmt.setDouble(4, vo.getMmoney());
        super.pstmt.setInt(5, vo.getMstatus());
        super.pstmt.setString(6, vo.getMlocate());
        super.pstmt.setString(7, vo.getMphone());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdate(Merchant vo) throws Exception {
        String sql = "UPDATE merchant SET mpassword=?, mname=?, mmoney=?, mstatus=?, mlocate=?, mphone=? WHERE mid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, vo.getMpassword());
        super.pstmt.setString(2, vo.getMname());
        super.pstmt.setDouble(3, vo.getMmoney());
        super.pstmt.setInt(4, vo.getMstatus());
        super.pstmt.setString(5, vo.getMlocate());
        super.pstmt.setString(6, vo.getMphone());
        super.pstmt.setString(7, vo.getMid());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doRemoveBatch(Set<String> ids) throws Exception {
        return super.removeHandle("merchant", "mid", ids);
    }

    @Override
    public Merchant findById(String id) throws Exception {
        Merchant vo = null;
        String sql = "SELECT mid, mpassword, mname, mmoney, mstatus, mlocate, mphone FROM merchant WHERE mid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, id);
        ResultSet rs = super.pstmt.executeQuery();
        if(rs.next()) {
            vo = new Merchant();
            vo.setMid(rs.getString(1));
            vo.setMpassword(rs.getString(2));
            vo.setMname(rs.getString(3));
            vo.setMmoney(rs.getDouble(4));
            vo.setMstatus(rs.getInt(5));
            vo.setMlocate(rs.getString(6));
            vo.setMphone(rs.getString(7));
        }
        return vo;
    }

    @Override
    public List<Merchant> findAll() throws Exception {
        List<Merchant> all = new ArrayList<Merchant>();
        String sql = "SELECT mid, mpassword, mname, mmoney, mstatus, mlocate, mphone FROM merchant";
        super.pstmt = super.conn.prepareStatement(sql);
        ResultSet rs = super.pstmt.executeQuery();
        while(rs.next()) {
            Merchant vo = new Merchant();
            vo.setMid(rs.getString(1));
            vo.setMpassword(rs.getString(2));
            vo.setMname(rs.getString(3));
            vo.setMmoney(rs.getDouble(4));
            vo.setMstatus(rs.getInt(5));
            vo.setMlocate(rs.getString(6));
            vo.setMphone(rs.getString(7));
            all.add(vo);
        }
        return all;
    }

    @Override
    public List<Merchant> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord) throws Exception {
        return null;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws Exception {
        return null;
    }

    @Override
    public boolean findLogin(Merchant vo) throws Exception {
        String sql = "SELECT * FROM merchant WHERE mid=? AND mpassword=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,vo.getMid());
        super.pstmt.setString(2, vo.getMpassword());
        ResultSet rs = super.pstmt.executeQuery();
        if(rs.next()) {
            return true;
        }
        return false;
    }

    @Override
    public Merchant findByName(String name) throws Exception {
        Merchant vo = null;
        String sql = "SELECT mid, mpassword, mname, mmoney, mstatus, mlocate, mphone FROM merchant WHERE mname=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, name);
        ResultSet rs = super.pstmt.executeQuery();
        if(rs.next()) {
            vo = new Merchant();
            vo.setMid(rs.getString(1));
            vo.setMpassword(rs.getString(2));
            vo.setMname(rs.getString(3));
            vo.setMmoney(rs.getDouble(4));
            vo.setMstatus(rs.getInt(5));
            vo.setMlocate(rs.getString(6));
            vo.setMphone(rs.getString(7));
        }
        return vo;
    }
}
