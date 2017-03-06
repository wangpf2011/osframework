package com.lnint.ssm.mapper;

import com.lnint.ssm.common.persistence.CrudDao;
import com.lnint.ssm.common.persistence.annotation.MyBatisDao;
import com.lnint.ssm.po.Orderdetail;

@MyBatisDao
public interface OrderdetailMapper extends CrudDao<Orderdetail> {

    int insertSelective(Orderdetail record);

    int updateSelective(Orderdetail record);
}