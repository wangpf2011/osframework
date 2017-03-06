package com.lnint.ssm.service;

import java.util.List;

import com.lnint.ssm.po.Items;
import com.lnint.ssm.po.ItemsCustom;
import com.lnint.ssm.po.ItemsQueryVo;

/**
 * 
 * <p>Title: ItemsService</p>
 * <p>Description:商品管理service </p>
 * @author wangpf
 * @version 2017-01-22
 */
public interface ItemsService {
	
	//商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	
	//根据id查询商品信息
	/**
	 * 
	 * <p>Title: findItemsById</p>
	 * <p>Description: </p>
	 * @param id 查询商品的id
	 * @return
	 * @throws Exception
	 */
	public ItemsCustom findItemsById(String id) throws Exception;
	
	//修改商品信息
	/**
	 * 
	 * <p>Title: updateItems</p>
	 * <p>Description: </p>
	 * @param id 修改商品的id
	 * @param items 修改的商品信息
	 * @throws Exception
	 */
	public void updateItems(String id,Items items) throws Exception;
}
