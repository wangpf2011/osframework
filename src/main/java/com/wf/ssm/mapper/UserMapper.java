package com.wf.ssm.mapper;

import com.wf.ssm.common.persistence.CrudDao;
import com.wf.ssm.common.persistence.annotation.MyBatisDao;
import com.wf.ssm.po.User;

@MyBatisDao
public interface UserMapper extends CrudDao<User> {
    int insertSelective(User record);

    int updateSelective(User record);
}