package com.jxnydx.store.service.back;

import com.jxnydx.store.vo.Merchant;

import java.util.List;
import java.util.Set;

public interface IMerchantServiceBack {
    public boolean insert(Merchant vo) throws Exception;
    public boolean update(Merchant vo) throws Exception;
    public boolean delete(Set<String> ids) throws Exception;
    public List<Merchant> list() throws Exception;
    /**
     * The Merchant is  by discovered in this way that using id to find.
     * @param id Merchant's id
     * @return Merchant Object
     * @throws Exception SQL Exception
     */
    public Merchant getMerchantInfo(String id) throws Exception;
}
