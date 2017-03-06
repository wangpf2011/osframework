package com.lnint.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lnint.ssm.common.persistence.CrudDao;
import com.lnint.ssm.common.persistence.annotation.MyBatisDao;
import com.lnint.ssm.po.Items;
import com.lnint.ssm.po.ItemsExample;

@MyBatisDao
public interface ItemsMapper extends CrudDao<Items> {
	//TODO 需要再整理！！基类！！
    int countByExample(ItemsExample example);

    int deleteByExample(ItemsExample example);

    int deleteByPrimaryKey(String id);

    int insert(Items record);

    int insertSelective(Items record);

    List<Items> selectByExampleWithBLOBs(ItemsExample example);

    List<Items> selectByExample(ItemsExample example);

    Items selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Items record, @Param("example") ItemsExample example);

    int updateByExampleWithBLOBs(@Param("record") Items record, @Param("example") ItemsExample example);

    int updateByExample(@Param("record") Items record, @Param("example") ItemsExample example);

    int updateByPrimaryKeySelective(Items record);

    int updateByPrimaryKeyWithBLOBs(Items record);

    int updateByPrimaryKey(Items record);
}