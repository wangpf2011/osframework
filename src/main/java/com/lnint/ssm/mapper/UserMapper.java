package com.lnint.ssm.mapper;

import com.lnint.ssm.common.persistence.CrudDao;
import com.lnint.ssm.common.persistence.annotation.MyBatisDao;
import com.lnint.ssm.po.User;

@MyBatisDao
public interface UserMapper extends CrudDao<User> {
    int insertSelective(User record);

    int updateSelective(User record);
}