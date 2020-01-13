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
}
