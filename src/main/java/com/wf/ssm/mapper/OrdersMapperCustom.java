package com.wf.ssm.mapper;

import java.util.List;

import com.wf.ssm.entity.Orders;
import com.wf.ssm.entity.OrdersCustom;
import com.wf.ssm.entity.User;

/**
 * <p>Title: OrdersMapperCustom</p>
 * <p>Description: 订单mapper</p>
 * @author	wangpf
 * @date	2015-4-23上午10:28:43
 */
public interface OrdersMapperCustom {
	
	//查询订单关联查询用户信息
	public List<OrdersCustom> findOrdersUser()throws Exception;
	
	//查询订单关联查询用户使用resultMap
	public List<Orders> findOrdersUserResultMap()throws Exception;
	
	//查询订单(关联用户)及订单明细
	public List<Orders>  findOrdersAndOrderDetailResultMap()throws Exception;
	
	//查询用户购买商品信息
	public List<User>  findUserAndItemsResultMap()throws Exception;
	
	//查询订单关联查询用户，用户信息是延迟加载
	public List<Orders> findOrdersUserLazyLoading()throws Exception;
}
