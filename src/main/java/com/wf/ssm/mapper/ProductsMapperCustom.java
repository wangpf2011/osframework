package com.wf.ssm.mapper;

import java.util.List;

import com.wf.ssm.common.persistence.annotation.MyBatisDao;
import com.wf.ssm.po.ProductsCustom;
import com.wf.ssm.po.ProductsQueryVo;

@MyBatisDao
public interface ProductsMapperCustom {
    //商品查询列表
	public List<ProductsCustom> findItemsList(ProductsQueryVo productsQueryVo)throws Exception;
}