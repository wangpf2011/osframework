package com.wf.ssm.mapper;

import com.wf.ssm.common.persistence.CrudDao;
import com.wf.ssm.common.persistence.annotation.MyBatisDao;
import com.wf.ssm.po.Products;

@MyBatisDao
public interface ProductsMapper extends CrudDao<Products> {
    int insertSelective(Products record);

    int updateSelective(Products record);
    
    int insertWithDetail(Products record, String mydetail);
}