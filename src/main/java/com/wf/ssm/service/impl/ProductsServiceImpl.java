package com.wf.ssm.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.wf.ssm.mapper.ProductsMapper;
import com.wf.ssm.mapper.ProductsMapperCustom;
import com.wf.ssm.po.Products;
import com.wf.ssm.po.ProductsCustom;
import com.wf.ssm.po.ProductsQueryVo;
import com.wf.ssm.service.ProductsService;

/**
 * <P>商品管理</P>
 * 
 * @version 1.0
 * @author wangpf
 * @date 2017年3月23日 下午4:18:12
 */
public class ProductsServiceImpl implements ProductsService{
	
	@Autowired
	private ProductsMapperCustom productsMapperCustom;
	
	@Autowired
	private ProductsMapper productsMapper;

	@Override
	public List<ProductsCustom> findProductsList(ProductsQueryVo productsQueryVo) throws Exception {
		//通过productsMapperCustom查询数据库
		return productsMapperCustom.findItemsList(productsQueryVo);
	}

	@Override
	public ProductsCustom findProductsById(String id) throws Exception {
		Products products = productsMapper.get(id);
		//中间对商品信息进行业务处理
		//....
		//返回productsCustom
		ProductsCustom productsCustom = new ProductsCustom();
		//将products的属性值拷贝到productsCustom
		BeanUtils.copyProperties(products, productsCustom);
		
		return productsCustom;
	}

	@Override
	public void updateProducts(String id, Products products) throws Exception {
		//添加业务校验，通常在service接口对关键参数进行校验
		//校验 id是否为空，如果为空抛出异常
		
		//更新商品信息使用updateByPrimaryKeyWithBLOBs根据id更新items表中所有字段，包括 大文本类型字段
		//updateByPrimaryKeyWithBLOBs要求必须转入id
		products.setId(id);
		productsMapper.update(products);
	}
}
