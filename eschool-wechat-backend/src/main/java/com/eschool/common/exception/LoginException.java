package com.eschool.common.exception;

/**
 * @Auther: Aaron
 * @Date: 2018-11-14 09:11:56
 * @Description: 
 */
public class LoginException extends RuntimeException {
	private static final long serialVersionUID = 1L;

    private String msg;
    private int code = 500;

    public LoginException(String msg) {
		super(msg);
		this.msg = msg;
	}

	public LoginException(String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
	}

	public LoginException(String msg, int code) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}

	public LoginException(String msg, int code, Throwable e) {
		super(msg, e);
		this.msg = msg;
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	
}
