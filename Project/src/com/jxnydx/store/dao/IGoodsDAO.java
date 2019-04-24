package com.jxnydx.store.dao;

import com.jxnydx.store.vo.Goods;

import java.util.List;

public interface IGoodsDAO extends IDAO<Integer, Goods>{
    /**
     * 更新商品状态，上架、下架或者删除
     * @param status 需要更新到到状态
     * @return 更新成功返回true，否则返回false
     * @throws Exception SQL EXCEPTION
     */
    public boolean updateStatus(Integer status, Integer gid) throws Exception;
    /**
     * The Merchant's Goods List is found by this way that using mid to seek.
     * @param mid Merchant's account
     * @return Goods List
     * @throws Exception SQL Exception
     */
    public List<Goods> findAllMerchantGoods(String mid) throws Exception;
}
