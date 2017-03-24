package com.wf.ssm.service;

import com.wf.ssm.po.User;

/**
 * <P>用户注册service</P>
 * 
 * @version 1.0
 * @author wangpf
 * @date 2017年3月23日 下午4:21:12
 */
public interface UserService {

	/**
	 * 用户注册
	 * @param user
	 * @return
	 * @throws Exception
	 * @author wangpf
	 * @date 2017年3月24日 下午10:38:46
	 */
	public int insert(User user) throws Exception;
}
