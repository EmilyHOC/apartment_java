package com.njwb.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter@ToString
public class Return<T> {

	private int code;
	private String message;
	private T data;
	public Return(int code, T data) {
		super();
		this.code = code;
		this.data = data;
		switch (code) {
		case 0:
			message = "success";
			break;
			
		case 1:
			message = "用户验证失败";
			break;
			
		case 2:
			message = "空数据";
			break;
			
		case 3:
			message = "用户名密码不匹配";
			break;
		
		case 4:
			message = "数据库错误";
			break;

		case 5:
			message = "权限不足";
			break;

		case 99:
			message = "未知错误";
			break;
		}
	}
	public Return(int code, String message, T data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
	
	
	
	
}
