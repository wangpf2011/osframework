package com.wf.ssm.mapper;

import java.util.List;

import com.wf.ssm.common.persistence.annotation.MyBatisDao;
import com.wf.ssm.entity.ProductsCustom;
import com.wf.ssm.entity.ProductsQueryVo;

@MyBatisDao
public interface ProductsMapperCustom {
    //商品查询列表
	public List<ProductsCustom> findItemsList(ProductsQueryVo productsQueryVo)throws Exception;
}