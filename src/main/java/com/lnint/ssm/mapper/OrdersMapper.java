package com.lnint.ssm.mapper;

import com.lnint.ssm.common.persistence.CrudDao;
import com.lnint.ssm.common.persistence.annotation.MyBatisDao;
import com.lnint.ssm.po.Orders;

@MyBatisDao
public interface OrdersMapper extends CrudDao<Orders> {
    int insertSelective(Orders record);

    int updateSelective(Orders record);
}