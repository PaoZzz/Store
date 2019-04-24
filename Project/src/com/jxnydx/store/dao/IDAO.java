package com.jxnydx.store.dao;

import java.util.List;
import java.util.Set;

/**
 * 定义公共的DAO操作接口标准，基本功能包括：增删该查（查:查询全部、分页查询、数据统计）
 * @author apple jxnydx
 *
 * @param <K> 表示需要操作的主键类型，由子接口实现
 * @param <V> 表示要操作的VO类型，由子接口实现
 */
public interface IDAO<K,V> {
	/**
	 * 实现数据的增加操作
	 * @param vo  包含了要增加数据的vo对象
	 * @return 如果数据保存成功返回true，否则返回false
	 * @throws Exception SQL执行异常
	 */
	public boolean doCreate(V vo) throws Exception;
	/**
	 * 实现数据修改操作，本次修改是根据ID进行全部字段的修改
	 * @param vo 包含了要修改数据的vo对象
	 * @return	如果修改成功返回true，否则返回false
	 * @throws Exception SQL异常
	 */
	public boolean doUpdate(V vo) throws Exception;
	/**
	 * 执行数据批量删除操作，要删除的数据用Set集合保存
	 * @param ids 包含了需要删除的对象
	 * @return	所有Set中的元素都被找到并且删除则返回true，否则返回false；
	 * @throws Exception SQL执行异常
	 */
	public boolean doRemoveBatch(Set<K> ids) throws Exception;
	/**
	 * 根据雇员编号查询雇员信息
	 * @param id 要查询的雇员ID号
	 * @return 如果查询到返回一个vo类雇员对象，如果雇员数据不存在返回null
	 * @throws Exception
	 */
	public V findById(K id) throws Exception;
	/**
	 * 查询指定数据表的全部记录，并以集合的形式返回
	 * @return 如果表中有数据，就返回一个VO的对象集合
	 * 如果表中无数据，那么集合长度为0，(Size()== 0)
	 * @throws Exception SQL执行异常
	 */
	public List<V> findAll() throws Exception;
	/**
	 * 分页进行数据的模糊查询，查询结果以集合的形式返回
	 * @param currentPage 当前所在页
	 * @param lineSize 每页获得的数据行数
	 * @param column 要进行模糊数据查询的列
	 * @param keyWord 模糊查询的关键字
	 * @return 如果表中有数据，就返回一个VO的对象集合
	 * 如果表中无数据，那么集合长度为0，(Size()== 0)
	 * @throws Exception Exception SQL执行异常
	 */
	public List<V> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord) throws Exception;
	/**
	 * 进行模糊查询的数据量统计，如果表中无记录就是0
	 * @param column 要进行模糊数据查询的列
	 * @param keyWord 模糊查询的关键字
	 * @return 返回表中的数据量，否则返回0
	 * @throws Exception SQL执行异常
	 */
	public Integer getAllCount(String column, String keyWord) throws Exception;
}
