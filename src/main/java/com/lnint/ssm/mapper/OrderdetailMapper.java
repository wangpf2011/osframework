package com.lnint.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lnint.ssm.common.persistence.CrudDao;
import com.lnint.ssm.common.persistence.annotation.MyBatisDao;
import com.lnint.ssm.po.Orderdetail;
import com.lnint.ssm.po.OrderdetailExample;

@MyBatisDao
public interface OrderdetailMapper extends CrudDao<Orderdetail> {
	//TODO 需要再整理！！基类！！
    int countByExample(OrderdetailExample example);

    int deleteByExample(OrderdetailExample example);

    int deleteByPrimaryKey(String id);

    int insert(Orderdetail record);

    int insertSelective(Orderdetail record);

    List<Orderdetail> selectByExample(OrderdetailExample example);

    Orderdetail selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Orderdetail record, @Param("example") OrderdetailExample example);

    int updateByExample(@Param("record") Orderdetail record, @Param("example") OrderdetailExample example);

    int updateByPrimaryKeySelective(Orderdetail record);

    int updateByPrimaryKey(Orderdetail record);
}