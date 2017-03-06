package com.lnint.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lnint.ssm.common.persistence.CrudDao;
import com.lnint.ssm.common.persistence.annotation.MyBatisDao;
import com.lnint.ssm.po.Orders;
import com.lnint.ssm.po.OrdersExample;

@MyBatisDao
public interface OrdersMapper extends CrudDao<Orders> {
	//TODO 需要再整理！！基类！！
    int countByExample(OrdersExample example);

    int deleteByExample(OrdersExample example);

    int deleteByPrimaryKey(String id);

    int insert(Orders record);

    int insertSelective(Orders record);

    List<Orders> selectByExample(OrdersExample example);

    Orders selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByExample(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
}