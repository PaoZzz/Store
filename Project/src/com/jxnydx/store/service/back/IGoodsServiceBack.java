package com.jxnydx.store.service.back;

import com.jxnydx.store.vo.Goods;
import com.jxnydx.store.vo.Merchant;

import java.util.List;
import java.util.Set;

public interface IGoodsServiceBack {
    public boolean insert(Goods vo) throws Exception;
    public boolean update(Goods vo) throws Exception;
    public boolean delete(Set<Integer> ids) throws Exception;
    public List<Goods> list() throws Exception;
    public Merchant findMerchant(Goods vo) throws Exception;
}
