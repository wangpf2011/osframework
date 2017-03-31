Restful SpringMVC CRUD

1、使用form标签，可以更快速开发表单页面，而且可以更方便的进行表单值的回显。

2、可以通过modelAttribute属性指定绑定的模型属性，若没有指定改属性，则默认从request域对象中读取command的表单bean，
如果该属性值也不存在，则发生错误。

3、一般情况下，通过GET请求获取表单页面，而通过POST请求提交页面，因此获取表单页面和提交表单页面的URL是相同的。
只要满足该最佳条件的契约，<form:form>标签就无需通过action属性指定表单提交的URL。

4、优雅的REST风格的资源URL不希望带.html或者.do等后缀，若将DispatcherServlet请求映射配置为/，
则SpringMVC将捕获WEB容器的所有请求，包括静态资源的请求，SpringMVC会将他们当成一个普通的请求处理，因找不到对应处理器将导致错误。

解决方法：在SpringMVC的配置文件中配置<mvc:default-servlet-handler/>
default-servlet-handler将在SpringMVC上下文中定义一个DefaultServletHttpRequestHandler，
它会对DispatcherServlet的请求进行筛选，如果发现是没有经过映射的请求，就将该请求交由WEB应用服务器默认的Servlet处理，
如果不是静态资源，才由DispatcherServlet继续处理。

一般WEB应用服务器默认的Servlet的名称都是default。若所使用的WEB服务器的默认Servlet名称不是default，则需要通过default-servlet-name属性显示指定。

dao 数据操作
entity 实体
handler SpringMVC处理器