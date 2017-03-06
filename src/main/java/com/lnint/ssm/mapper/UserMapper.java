package com.lnint.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lnint.ssm.common.persistence.CrudDao;
import com.lnint.ssm.common.persistence.annotation.MyBatisDao;
import com.lnint.ssm.po.User;
import com.lnint.ssm.po.UserExample;

@MyBatisDao
public interface UserMapper extends CrudDao<User> {
	//TODO 需要再整理！！基类！！
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}