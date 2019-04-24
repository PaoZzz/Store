package com.jxnydx.store.dao;

import com.jxnydx.store.vo.Admin;

public interface IAdminDAO extends IDAO<String, Admin> {
	/**
	 * 本操作实现管理员的登录功能，在登录完成之后要将上一次的登录时间取出
	 * 传递的是vo类的一个对象，所以将登录日期返回到此对象中即可返回
	 * @param vo 包含有aid、password的数据对象
	 * @return 登录成功返回true、否则返回false
	 * @throws Exception
	 */
	public boolean findLogin(Admin vo) throws Exception;
	/**
	 * 本操作是更新最后一次的登录日期，只需要传入要更新的管理员编号即可
	 * @param aid 管理员编号
	 * @return 更新成功返回true，否则返回false
	 * @throws Exception
	 */
	public boolean doUpdateLastdate(String aid) throws Exception;
}
