package com.wf.ssm;

import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.subject.WebSubject;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;

/**
 * Controller Test（SpringMVC+Junit4+Shiro）
 * 
 * @author wangpf
 */
@WebAppConfiguration
//声明一个事务管理 每个单元测试都进行事务回滚 无论成功与否  
@TransactionConfiguration(defaultRollback = true)  
@Transactional
public class ControllerTest1 extends ControllerBaseJunitTest  {
    @Autowired  
    private WebApplicationContext wac;  
    protected MockMvc mockMvc;
    public Subject subject;
    @Autowired
    private DefaultWebSecurityManager securityManager;
    //模拟request,response  
    protected MockHttpSession mockSession;
    protected MockHttpServletRequest mockHttpServletRequest;
    protected MockHttpServletResponse mockHttpServletResponse;
    
    // 执行测试方法之前初始化模拟request,response
    @Before    
    public void setUp(){
        this.mockMvc = webAppContextSetup(this.wac)
                //.addFilter(new ParamValidationFilter(), "/*")
                .addFilter(new DelegatingFilterProxy("shiroFilter", wac), "/*")
                .build();
        mockHttpServletRequest = new MockHttpServletRequest(wac.getServletContext());
        mockHttpServletResponse = new MockHttpServletResponse();
        mockSession = new MockHttpSession(wac.getServletContext());
        mockHttpServletRequest.setSession(mockSession);
        SecurityUtils.setSecurityManager(securityManager);
        subject = new WebSubject.Builder(mockHttpServletRequest, mockHttpServletResponse).buildSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("admin","admin123");
        subject.login(token);
    }

    @Test  
    public void test0() {
        try {
            MockHttpServletRequestBuilder mock = MockMvcRequestBuilders.post("/a/evs/vehicle/list").param("carFrame", "XXXXXXXXXX").param("carPlatenum", "京ACB005");
            mock.session(mockSession);
            mockMvc.perform(mock).andExpect(status().isOk()).andDo(print());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("第一个测试方法*******");
    }
}