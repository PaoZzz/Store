package com.jxnydx.store.service.front;

import com.jxnydx.store.vo.Merchant;

public interface IMerchantServiceFront {
    /**
     * 用户登录操作，调用的是IMerchantDAO.findByLogin()方法
     * @param vo 包含有mid与password的member对象
     * @return 登录成功返回true，否则返回false
     * @throws Exception
     */
    public boolean login(Merchant vo) throws Exception;
    /**
     * The Merchant is  by discovered in this way that using id to find.
     * @param id Merchant's id
     * @return Merchant Object
     * @throws Exception SQL Exception
     */
    public Merchant getMerchantInfo(String id) throws Exception;
    /**
     * Relizing informations of Merchant, including password, locate and phone, are changed.
     * @param vo Need to update, Object of Merchant
     * @return If come true, will return true, else false.
     * @throws Exception SQL Exception
     */
    public boolean update(Merchant vo) throws Exception;
}
