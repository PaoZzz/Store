package com.jxnydx.store.service.front;

import com.jxnydx.store.vo.Orders;

import java.util.List;

public interface IOrdersServiceFront {
    public boolean insert(Orders vo) throws Exception;
    public boolean update(Orders vo) throws Exception;
    public List<Orders> listStudentOrders(String sno) throws Exception;
    public List<Orders> listMerchantOrders(String mid) throws Exception;
    public boolean updateStatus(Integer oid, Integer status) throws Exception;
    /**
     * Using account of Student, Find they all Orders.
     * @param sno Student's account
     * @return List<Orders> Object
     * @throws Exception SQL Exception
     */
    public List<Orders> getStudentAllOrders(String sno) throws Exception;
    /**
     * It is obtaining Orders' List that there are seeking mid of Merchant in table of merchant in MySQL
     * @param mid account of Merchant
     * @return List<Order> Object
     * @throws Exception SQL Exception
     */
    public List<Orders> getMerchantAllOrders(String mid) throws Exception;
}
