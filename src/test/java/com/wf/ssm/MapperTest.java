package com.wf.ssm;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.web.WebAppConfiguration;

import com.wf.ssm.entity.User;
import com.wf.ssm.mapper.UserMapper;

/**
 * <P>Dao Test</P>
 * 
 * @version 1.0
 * @author wangpf
 * @date 2017年4月9日 下午8:34:33
 */
@WebAppConfiguration
public class MapperTest extends BaseJunitTest {
	@Autowired  
    private UserMapper userMapper;
    
    @Autowired
    private ApplicationContext ac;
    
    @Test  
    public void test0() {
    	User user1 = userMapper.get("1");
		System.out.println(user1);
        System.out.println("第一个测试方法*******");  
    }
    
    /**
     * 如果需要从applicationcontext中取出对应的bean，需要添加注解@WebAppConfiguration
     */
    @Test  
    public void test1() {
    	UserMapper userMapper1 = (UserMapper)ac.getBean("userMapper");
    	User user = userMapper.get("1");
		System.out.println(user);
    	user.setUsername("测试用户22");
		userMapper1.update(user);
        System.out.println("第二个测试方法*******");  
    }
}
