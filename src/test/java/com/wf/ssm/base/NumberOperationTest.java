package com.wf.ssm.base;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

//指定运行器
//@RunWith(JUnit4ClassRunner.class)
public class NumberOperationTest {
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("setUpBeforeClass...");
    }
    
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("tearDownAfterClass...");
    }
    
    /**
     * @Before：使用了该元数据的方法在每个测试方法执行之前都要执行一次。
     * 注意：@Before标示的方法只能有一个。
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        System.out.println("setUp...");
    }
    
    /**
     * @After：使用了该元数据的方法在每个测试方法执行之后要执行一次。
     * 注意：@After标示的方法只能有一个。
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown...");
    }

    @Test
    public void add() {
        int x = 1;
        int y = 1;
        int result = x + y;
        int expResult = 2;
        assertEquals(expResult, result);
        assertTrue("error message", 4 > 3);
        
        //assertThat(T actual, Matcher<? super T> matcher)
        //Matcher规则匹配器，需要下载hamcrest包
        assertThat(expResult, is(2));
        System.out.println("add...");
    }
    
    @Test
    public void minus() {
        int x = 1;
        int y = 1;
        int result = x - y;
        int expResult = 0;
        assertEquals(expResult, result);
        System.out.println("minus...");
    }
    
    /**
     * 该元数据标记的测试方法在测试中会被忽略
     */
    @Ignore("该方法还没有实现")
    public void ignore() {
      System.out.println("ignore...");
    }
    
    /**
     * 对错误的测试
     */
    @Test(expected=IndexOutOfBoundsException.class)
    public void outOfBounds() {
    	System.out.println("outOfBounds...");
        new ArrayList<Object>().get(1);
    }
    
    /**
     * 如果测试方法在指定时间内没有完成，则测试失败
     */
    @Test(timeout=2000)
    public void timeout() {
        System.out.println("timeout...");
    }
}