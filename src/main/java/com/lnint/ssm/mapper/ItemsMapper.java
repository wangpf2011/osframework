package com.lnint.ssm.mapper;

import com.lnint.ssm.common.persistence.CrudDao;
import com.lnint.ssm.common.persistence.annotation.MyBatisDao;
import com.lnint.ssm.po.Items;

@MyBatisDao
public interface ItemsMapper extends CrudDao<Items> {
    int insertSelective(Items record);

    int updateSelective(Items record);
    
    int insertWithDetail(Items record, String mydetail);
}