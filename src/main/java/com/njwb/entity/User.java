package com.njwb.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter@ToString
public class User {
	private int id;   //数据库内id
	private String user_id;		//登录用用户名
	private String user_name;	//用户姓名
	private String user_sex;	//用户性别
	private String user_phone;	//用户电话
	private String user_pwd; 	//用户密码
}
