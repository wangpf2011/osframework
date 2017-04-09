package com.wf.ssm;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.web.WebAppConfiguration;

import com.wf.ssm.entity.User;
import com.wf.ssm.service.UserService;

/**
 * <P>Service Test</P>
 * 
 * @version 1.0
 * @author wangpf
 * @date 2017年4月9日 下午8:34:57
 */
@WebAppConfiguration
public class ServiceTest extends BaseJunitTest {
	@Autowired
	private UserService userService;
	
	@Autowired
    private ApplicationContext ac;
	
    @Test  
    public void test0() {
    	try {
			User user = new User();
			user.setId("1");
			user.setUsername("飞翔");
			userService.insert(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
        System.out.println("第一个测试方法*******");  
    }  
    
    /**
     * 如果需要从applicationcontext中取出对应的bean，需要添加注解@WebAppConfiguration
     */
    @Test  
    public void test1() {
    	try {
    		UserService userService1 = (UserService)ac.getBean("userService");
			User user = new User();
			user.setId("1");
			user.setUsername("飞翔");
			userService1.insert(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
        System.out.println("第二个测试方法*******");  
    }
}
