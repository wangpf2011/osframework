package com.wf.ssm.ws.interceptor;

/**
 * <P>全局工具类</P>
 * 
 * @version 1.0
 * @author wangpf
 * @since JDK 1.6
 * 2017年04月7日 上午12:47:11
 */
public class WSUtils {
	/**
	 * 异常类型
	 * 
	 * 0: 无异常
	 * 1： 用户名/密码校验失败
	 * ......
	 */
	public static int errorType = 0;
	
	/**
	 * 用户名/密码校验失败返回字符串
	 * @return
	 * @author wangpf
	 */
	public static String authFail() {
		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DBSET RESULT=\"0\" AUTH=\"FAIL\"></DBSET>";
	}
	
	/**
	 * 返回空结果集
	 * @return
	 * @author wangpf
	 * @date 2016年1月7日 上午12:50:21
	 */
	public static String blankRst() {
		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DBSET RESULT=\"0\"></DBSET>";
	}
}
