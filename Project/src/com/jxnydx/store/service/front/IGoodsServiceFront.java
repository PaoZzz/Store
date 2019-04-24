package com.jxnydx.store.service.front;

import com.jxnydx.store.vo.Goods;

import java.util.List;
import java.util.Set;

public interface IGoodsServiceFront {
    public boolean insert(Goods vo) throws Exception;
    public boolean update(Goods vo) throws Exception;
    public boolean delete(Set<Integer> ids) throws Exception;
    public List<Goods> list() throws Exception;
    public boolean updateStatus(Goods vo) throws Exception;
    /**
     * The method, program can get Goods List through using mid to seek.
     * @param mid Merchant's account
     * @return List<Goods> Object
     */
    public List<Goods> getAllMerchantGoods(String mid) throws Exception;
}
