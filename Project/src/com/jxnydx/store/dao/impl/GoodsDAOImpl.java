package com.jxnydx.store.dao.impl;

import com.jxnydx.store.dao.IGoodsDAO;
import com.jxnydx.store.vo.Goods;
import com.jxnydx.util.dao.AbstractDAOImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GoodsDAOImpl extends AbstractDAOImpl implements IGoodsDAO{
    public GoodsDAOImpl(Connection conn) {
        super(conn);
    }

    @Override
    public boolean doCreate(Goods vo) throws Exception {
        String sql = "INSERT INTO goods(mid, gname, gprice, gstatus) VALUES(?, ?, ?, ?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, vo.getMid());
        super.pstmt.setString(2, vo.getGname());
        super.pstmt.setDouble(3, vo.getGprice());
        super.pstmt.setInt(4, vo.getGstatus());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdate(Goods vo) throws Exception {
        String sql = "UPDATE goods SET mid=?, gname=?, gprice=?, gstatus=? WHERE gid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, vo.getMid());
        super.pstmt.setString(2, vo.getGname());
        super.pstmt.setDouble(3, vo.getGprice());
        super.pstmt.setInt(4, vo.getGstatus());
        super.pstmt.setInt(5, vo.getGid());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doRemoveBatch(Set<Integer> ids) throws Exception {
        return super.removeHandle("goods", "gid", ids);
    }

    @Override
    public Goods findById(Integer id) throws Exception {
        Goods vo = null;
        String sql = "SELECT gid, mid, gname, gprice, gstatus FROM goods WHERE gid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1, id);
        ResultSet rs = super.pstmt.executeQuery();
        if(rs.next()) {
            vo = new Goods();
            vo.setGid(rs.getInt(1));
            vo.setMid(rs.getString(2));
            vo.setGname(rs.getString(3));
            vo.setGprice(rs.getDouble(4));
            vo.setGstatus(rs.getInt(5));
        }
        return vo;
    }

    @Override
    public List<Goods> findAll() throws Exception {
        List<Goods> all = new ArrayList<Goods>();
        String sql = "SELECT gid, mid, gname, gprice, gstatus FROM goods";
        super.pstmt = super.conn.prepareStatement(sql);
        ResultSet rs = super.pstmt.executeQuery();
        while(rs.next()) {
            Goods vo = new Goods();
            vo.setGid(rs.getInt(1));
            vo.setMid(rs.getString(2));
            vo.setGname(rs.getString(3));
            vo.setGprice(rs.getDouble(4));
            vo.setGstatus(rs.getInt(5));
            all.add(vo);
        }
        return all;
    }

    @Override
    public List<Goods> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord) throws Exception {
        return null;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws Exception {
        return null;
    }

    @Override
    public boolean updateStatus(Integer status, Integer gid) throws Exception {
        String sql = "UPDATE goods SET gstatus=? WHERE gid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1, status);
        super.pstmt.setInt(2, gid);
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public List<Goods> findAllMerchantGoods(String mid) throws Exception {
        List<Goods> all = new ArrayList<Goods>();
        String sql = "SELECT gid, mid, gname, gprice, gstatus FROM goods WHERE mid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, mid);
        ResultSet rs = super.pstmt.executeQuery();
        while(rs.next()) {
            Goods vo = new Goods();
            vo.setGid(rs.getInt(1));
            vo.setMid(rs.getString(2));
            vo.setGname(rs.getString(3));
            vo.setGprice(rs.getDouble(4));
            vo.setGstatus(rs.getInt(5));
            all.add(vo);
        }
        return all;
    }
}
