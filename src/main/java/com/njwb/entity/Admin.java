package com.njwb.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter@ToString
public class Admin {
	private int id;         //数据库内id
	private String admin_name;  //用户名
	private String admin_pwd;	//密码
	private String admin_kind; //用户类型
	public String getAdmin_name() {
		return null;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public void setAdmin_pwd(String admin_pwd) {
		this.admin_pwd = admin_pwd;
	}
	public String getAdmin_pwd() {
		// TODO Auto-generated method stub
		return null;
	}
}
