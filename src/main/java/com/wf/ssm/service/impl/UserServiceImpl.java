package com.wf.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.wf.ssm.mapper.UserMapper;
import com.wf.ssm.entity.User;
import com.wf.ssm.service.UserService;

/**
 * <P>用户注册service</P>
 * 
 * @version 1.0
 * @author wangpf
 * @date 2017年3月23日 下午4:21:12
 */
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	/**
	 * 用户注册
	 * @param user
	 * @return
	 * @throws Exception
	 * @author wangpf
	 * @date 2017年3月24日 下午10:38:46
	 */
	@Override
	public int insert(User user) throws Exception {
		return userMapper.insert(user);
	}
}
