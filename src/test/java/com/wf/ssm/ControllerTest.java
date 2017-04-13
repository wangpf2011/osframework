package com.wf.ssm;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Controller Test
 * 
 * @author wangpf
 */
@WebAppConfiguration
//可以声明一个事务管理 每个单元测试都进行事务回滚 无论成功与否  
@TransactionConfiguration(defaultRollback = true)  
@Transactional
public class ControllerTest extends ControllerBaseJunitTest  {
	@Autowired  
    private WebApplicationContext wac;
	private MockMvc mockMvc;
	
	@Before  
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();  
    }
	
	/**
     * perform：执行一个RequestBuilder请求，会自动执行SpringMVC的流程并映射到相应的控制器执行处理；
     * andExpect：添加ResultMatcher验证规则，验证控制器执行完成后结果是否正确；
     * andDo：添加ResultHandler结果处理器，比如调试时打印结果到控制台；
     * andReturn：最后返回相应的MvcResult；然后进行自定义验证/进行下一步的异步处理；
     */
    @Test  
    public void test0() throws Exception {
    	mockMvc.perform(post("/doLogin").param("username", "admin").param("password", "admin123")).andExpect(status().isOk())  
        .andDo(print());
        System.out.println("第一个测试方法*******");
    }
    
    /**
     * perform：执行一个RequestBuilder请求，会自动执行SpringMVC的流程并映射到相应的控制器执行处理；
     * andExpect：添加ResultMatcher验证规则，验证控制器执行完成后结果是否正确；
     * andDo：添加ResultHandler结果处理器，比如调试时打印结果到控制台；
     * andReturn：最后返回相应的MvcResult；然后进行自定义验证/进行下一步的异步处理；
     */
    @Test
    //有些单元测试你不希望回滚  
    @Rollback(false)
    public void test1() throws Exception {
    	mockMvc.perform(post("/doLogin").param("username", "admin").param("password", "admin123")).andExpect(status().isOk())  
        .andDo(print());
        System.out.println("第二个测试方法*******");
    }
}