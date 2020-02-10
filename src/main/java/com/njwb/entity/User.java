package com.njwb.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author 10579
 *
 */
@Setter@Getter@ToString
public class User {
	private int id;   //数据库内id
	private String user_id;		//登录用用户名
	private String user_name;	//用户姓名
	private String user_sex;	//用户性别
	private String user_phone;	//用户电话
	private String user_pwd; 	//用户密码
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public void setId(int id) {
		this.id = id;
	}
}
