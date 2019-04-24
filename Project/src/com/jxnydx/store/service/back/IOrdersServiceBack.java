package com.jxnydx.store.service.back;

import com.jxnydx.store.vo.Orders;

import java.util.List;
import java.util.Set;

public interface IOrdersServiceBack {
    public boolean insert(Orders vo) throws Exception;
    public boolean update(Orders vo) throws Exception;
    public boolean delete(Set<Integer> ids) throws Exception;
    public List<Orders> list() throws Exception;
    public boolean updateStatus(Orders vo) throws Exception;
}
