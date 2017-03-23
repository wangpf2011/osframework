package com.wf.ssm.exception;

/**
 * <p>Title: CustomException</p>
 * <p>Description:系统 自定义异常类，针对预期的异常，需要在程序中抛出此类的异常 </p>
 * @author wangpf
 * @version 2017-01-15
 */
public class CustomException extends Exception {
	private static final long serialVersionUID = 7115068805191736754L;
	//异常信息
	public String message;
	
	public CustomException(String message){
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
