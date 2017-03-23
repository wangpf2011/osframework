package com.wf.ssm.service;

import java.util.List;

import com.wf.ssm.po.Products;
import com.wf.ssm.po.ProductsCustom;
import com.wf.ssm.po.ProductsQueryVo;

/**
 * <P>商品管理service</P>
 * 
 * @version 1.0
 * @author wangpf
 * @date 2017年3月23日 下午4:21:12
 */
public interface ProductsService {
	
	//商品查询列表
	public List<ProductsCustom> findProductsList(ProductsQueryVo productsQueryVo) throws Exception;
	
	//根据id查询商品信息
	/**
	 * 
	 * <p>Title: findProductsById</p>
	 * <p>Description: </p>
	 * @param id 查询商品的id
	 * @return
	 * @throws Exception
	 */
	public ProductsCustom findProductsById(String id) throws Exception;
	
	//修改商品信息
	/**
	 * 
	 * <p>Title: updateProducts</p>
	 * <p>Description: </p>
	 * @param id 修改商品的id
	 * @param products 修改的商品信息
	 * @throws Exception
	 */
	public void updateProducts(String id, Products products) throws Exception;
}
