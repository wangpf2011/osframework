package com.wf.ssm.mapper;

import java.util.Date;

import org.junit.Test;

import com.wf.ssm.po.User;
import com.wf.ssm.utils.ValidateUtils;

public class ValidateTest {
	
	@Test
	public void testUser() {
		User user = new User();
		user.setUsername("王珂");
		user.setAddress("济南市");
		user.setAge(20);
		user.setBirthday(new Date());
		user.setMobile("13000000000");
		user.setSex("男");
		String result = ValidateUtils.validateModel(user);
		System.out.println(result);
	}
}
