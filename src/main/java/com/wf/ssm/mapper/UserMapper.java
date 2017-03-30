package com.wf.ssm.mapper;

import com.wf.ssm.common.persistence.CrudDao;
import com.wf.ssm.common.persistence.annotation.MyBatisDao;
import com.wf.ssm.entity.User;

@MyBatisDao
public interface UserMapper extends CrudDao<User> {
	int insert(User record);
	
    int insertSelective(User record);

    int updateSelective(User record);
}