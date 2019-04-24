package com.jxnydx.store.dao.impl;

import com.jxnydx.store.dao.IOrdersDAO;
import com.jxnydx.store.vo.Orders;
import com.jxnydx.util.dao.AbstractDAOImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class OrdersDAOImpl extends AbstractDAOImpl implements IOrdersDAO {
    public OrdersDAOImpl(Connection conn) {
        super(conn);
    }

    @Override
    public boolean doCreate(Orders vo) throws Exception {
        String sql = "INSERT INTO orders(mid, sno, gname,credate, pay, ostatus) VALUES(?, ?, ?, ?, ?, ?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, vo.getMid());
        super.pstmt.setString(2, vo.getSno());
        super.pstmt.setString(3, vo.getGname());
        super.pstmt.setTimestamp(4, new Timestamp(new java.util.Date().getTime()));
        super.pstmt.setDouble(5, vo.getPay());
        super.pstmt.setInt(6, vo.getOstatus());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdate(Orders vo) throws Exception {
        String sql = "UPDATE orders SET mid=?, sno=?, gname=?, pay=?, ostatus=? WHERE oid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, vo.getMid());
        super.pstmt.setString(2, vo.getSno());
        super.pstmt.setString(2, vo.getGname());
        super.pstmt.setDouble(4, vo.getPay());
        super.pstmt.setInt(5, vo.getOstatus());
        super.pstmt.setInt(6, vo.getOid());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doRemoveBatch(Set<Integer> ids) throws Exception {
        return super.removeHandle("orders", "oid", ids);
    }

    @Override
    public Orders findById(Integer id) throws Exception {
        Orders vo = null;
        String sql = "SELECT oid, mid, sno, gname, credate, pay, ostatus FROM orders WHERE oid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1, id);
        ResultSet rs = super.pstmt.executeQuery();
        if(rs.next()) {
            vo = new Orders();
            vo.setOid(rs.getInt(1));
            vo.setMid(rs.getString(2));
            vo.setSno(rs.getString(3));
            vo.setGname(rs.getString(4));
            vo.setCredate(rs.getTimestamp(5));
            vo.setPay(rs.getDouble(6));
            vo.setOstatus(rs.getInt(7));
        }
        return vo;
    }

    @Override
    public List<Orders> findAll() throws Exception {
        List<Orders> all = new ArrayList<Orders>();
        String sql = "SELECT oid, mid, sno, gname, credate, pay, ostatus FROM orders";
        super.pstmt = super.conn.prepareStatement(sql);
        ResultSet rs = super.pstmt.executeQuery();
        while(rs.next()) {
            Orders vo = new Orders();
            vo.setOid(rs.getInt(1));
            vo.setMid(rs.getString(2));
            vo.setSno(rs.getString(3));
            vo.setGname(rs.getString(4));
            vo.setCredate(rs.getTimestamp(5));
            vo.setPay(rs.getDouble(6));
            vo.setOstatus(rs.getInt(7));
            all.add(vo);
        }
        return all;
    }

    @Override
    public List<Orders> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord) throws Exception {
        return null;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws Exception {
        return null;
    }

    @Override
    public boolean updatePay(Orders vo) throws Exception {
        String sql = "UPDATE orders SET pay=? WHERE oid=? AND ostatus=0";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setDouble(1, vo.getPay());
        super.pstmt.setInt(2, vo.getOid());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public List<Orders> findStudentAllOrders(String sno) throws Exception {
        List<Orders> all = new ArrayList<Orders>();
        String sql = "SELECT oid, mid, sno, gname, credate, pay, ostatus FROM orders WHERE sno=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, sno);
        ResultSet rs = super.pstmt.executeQuery();
        while(rs.next()) {
            Orders vo = new Orders();
            vo.setOid(rs.getInt(1));
            vo.setMid(rs.getString(2));
            vo.setSno(rs.getString(3));
            vo.setGname(rs.getString(4));
            vo.setCredate(rs.getTimestamp(5));
            vo.setPay(rs.getDouble(6));
            vo.setOstatus(rs.getInt(7));
            all.add(vo);
        }
        return all;
    }

    @Override
    public List<Orders> findMerchantAllOrders(String mid) throws Exception {
        List<Orders> all = new ArrayList<Orders>();
        String sql = "SELECT oid, mid, sno, gname, credate, pay, ostatus FROM orders WHERE mid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, mid);
        ResultSet rs = super.pstmt.executeQuery();
        while(rs.next()) {
            Orders vo = new Orders();
            vo.setOid(rs.getInt(1));
            vo.setMid(rs.getString(2));
            vo.setSno(rs.getString(3));
            vo.setGname(rs.getString(4));
            vo.setCredate(rs.getTimestamp(5));
            vo.setPay(rs.getDouble(6));
            vo.setOstatus(rs.getInt(7));
            all.add(vo);
        }
        return all;
    }

    @Override
    public boolean updateStatus(Integer oid, Integer status) throws Exception {
        String sql = "UPDATE orders SET ostatus=" + status + " WHERE oid=" + oid;
        super.pstmt = super.conn.prepareStatement(sql);
        return super.pstmt.executeUpdate() > 0;
    }
}
