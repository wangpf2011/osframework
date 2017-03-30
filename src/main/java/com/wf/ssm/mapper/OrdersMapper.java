package com.wf.ssm.mapper;

import com.wf.ssm.common.persistence.CrudDao;
import com.wf.ssm.common.persistence.annotation.MyBatisDao;
import com.wf.ssm.entity.Orders;

@MyBatisDao
public interface OrdersMapper extends CrudDao<Orders> {
    int insertSelective(Orders record);

    int updateSelective(Orders record);
}