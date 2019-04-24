package com.jxnydx.store.dao;

import com.jxnydx.store.vo.Orders;

import java.util.List;

public interface IOrdersDAO extends IDAO<Integer, Orders>{
    /**
     * Changing price of goods in orders.
     * @param vo orders
     * @return If change is successful, it will return true, else return false.
     * @throws Exception SQL Exception
     */
    public boolean updatePay(Orders vo) throws Exception;
    /**
     * We can obtain Orders' List, and the reason that we writing SQL language to make MySQL understanding our significance.
     * @param sno account of Student
     * @return List Orders
     * @throws Exception SQL Exception
     */
    public List<Orders> findStudentAllOrders(String sno) throws Exception;

    /**
     * It is easy to look up Orders' List of Merchant that use account search.
     * @param mid  account
     * @return  List<Orders> Object
     * @throws Exception SQL Exception
     */
    public List<Orders> findMerchantAllOrders(String mid) throws Exception;
    /**
     * Change status of the order that is found by oid to become status.
     * @param oid Need to seek order's oid
     * @param status Meed to change order's status
     * @return If program success to change, return true, else return false.
     * @throws Exception SQL Exception.
     */
    public boolean updateStatus(Integer oid, Integer status) throws Exception;

}
