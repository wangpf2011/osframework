一、SpringMVC集成Junit4需要两个jar包：junit-4.10.jar和spring-test-4.2.0.RELEASE.jar。
首先我们可以先写一个单元测试的基类BaseJunitTest：
@RunWith(SpringJUnit4ClassRunner.class)  注解让测试运行于Spring测试环境；
@ContextConfiguration注解加载的是Spring的配置文件

二、Spring3以后可以自定义环境配置 <beans profile="">
以后就不用为了区分Test, Dev, Production环境，搞几个只有细微区别的application.xml, application-test.xml及引用它们的web.xml了。
首先，在applicationContext.xm文件末尾加入不同环境的定义，比如不同的dataSource
<!-- Production 环境 -->
<beans profile="production">
    <!-- 主业务数据库 数据源配置, 使用Druid数据库连接池 -->
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource" init-method="init" destroy-method="close"> 
        <!-- 数据源驱动类可不写，Druid默认会自动根据URL识别DriverClass -->
        <property name="driverClassName" value="${jdbc.driver}" />
    
        <!-- 基本属性 url、user、password -->
        <property name="url" value="${jdbc.url}" />
        <property name="username" value="${jdbc.username}" />
        <property name="password" value="${jdbc.password}" />
    
        <!-- 配置初始化大小、最小、最大 -->
        <property name="initialSize" value="${jdbc.pool.minIdle}" />
        <property name="minIdle" value="${jdbc.pool.minIdle}" /> 
        <property name="maxActive" value="${jdbc.pool.maxActive}" />
    
        <!-- 配置获取连接等待超时的时间 -->
        <property name="maxWait" value="120000" />
    </bean>
</beans>
  
<!-- Test 环境 -->
<beans profile="test">
    <!-- 主业务数据库 数据源配置, 使用Druid数据库连接池 -->
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource" init-method="init" destroy-method="close"> 
        <!-- 数据源驱动类可不写，Druid默认会自动根据URL识别DriverClass -->
        <property name="driverClassName" value="${jdbc.driver}" />
    
        <!-- 基本属性 url、user、password -->
        <property name="url" value="${jdbc.url}" />
        <property name="username" value="${jdbc.username}" />
        <property name="password" value="${jdbc.password}" />
    
        <!-- 配置初始化大小、最小、最大 -->
        <property name="initialSize" value="${jdbc.pool.minIdle}" />
        <property name="minIdle" value="${jdbc.pool.minIdle}" /> 
        <property name="maxActive" value="${jdbc.pool.maxActive}" />
    
        <!-- 配置获取连接等待超时的时间 -->
        <property name="maxWait" value="120000" />
    </bean>
</beans>

然后，在web.xml里定义使用的profile，采用context-param形式定义，注意这里定义的是default值。
<context-param>  
    <param-name>spring.profiles.default</param-name>  
    <param-value>production</param-value>  
</context-param> 
在非生产环境，可以用系统变量"spring.profiles.active"进行覆盖。

三、Spring-mvc中Controller中的方法的参数为什么用Model不用request
HttpServletRequest要和web容器耦合在一起，难以进行单元测试和复用！！

四、在xml文件中有以下几类字符要进行转义替换：
&lt;   <   小于号
&gt;   >   大于号
&amp;  &   和
&apos; '   单引号
&quot; "   双引号