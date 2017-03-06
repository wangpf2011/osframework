package com.lnint.ssm.mapper;

import java.util.List;

import com.lnint.ssm.common.persistence.annotation.MyBatisDao;
import com.lnint.ssm.po.ItemsCustom;
import com.lnint.ssm.po.ItemsQueryVo;

@MyBatisDao
public interface ItemsMapperCustom {
    //商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;
}