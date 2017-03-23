package com.wf.ssm.mapper;

import com.wf.ssm.common.persistence.CrudDao;
import com.wf.ssm.common.persistence.annotation.MyBatisDao;
import com.wf.ssm.po.Orderdetail;

@MyBatisDao
public interface OrderdetailMapper extends CrudDao<Orderdetail> {

    int insertSelective(Orderdetail record);

    int updateSelective(Orderdetail record);
}