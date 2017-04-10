package com.wf.ssm;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 在用到ApplicationContext的单元测试用例中，
 * 用 @ActiveProfiles定义，区分Test, Dev, Production环境
 * 
 * @author wangpf
 */
@RunWith(SpringJUnit4ClassRunner.class)    
@ContextConfiguration(locations = {"classpath:/spring/applicationContext-dao.xml","classpath:/spring/applicationContext-service.xml","classpath:/spring/applicationContext-transaction.xml","classpath:/spring/springmvc.xml"})
//@ActiveProfiles("test")
public class ControllerBaseJunitTest {
      
}
