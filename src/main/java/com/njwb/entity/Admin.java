package com.njwb.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter@ToString
public class Admin {
	private int id;         //数据库内id
	private String admin_name;  //用户名
	@JSONField(serialize = false)
	private String admin_pwd;	//密码
	private String admin_kind; //用户类型
	private String admin_realname; //管理员姓名
	private String admin_worktime;//工作年限
	//设置时区为上海时区，时间格式自己据需求定。
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date admin_lastlogin;//上次登录时间
	private String admin_score; //工作绩效
	private String admin_remarks; //备注
	public String getAdmin_remarks() {
		return admin_remarks;
	}
	public void setAdmin_remarks(String admin_remarks) {
		this.admin_remarks = admin_remarks;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getAdmin_pwd() {
		return admin_pwd;
	}
	public void setAdmin_pwd(String admin_pwd) {
		this.admin_pwd = admin_pwd;
	}
	public String getAdmin_kind() {
		return admin_kind;
	}
	public void setAdmin_kind(String admin_kind) {
		this.admin_kind = admin_kind;
	}
	public String getAdmin_realname() {
		return admin_realname;
	}
	public void setAdmin_realname(String admin_realname) {
		this.admin_realname = admin_realname;
	}
	public String getAdmin_worktime() {
		return admin_worktime;
	}
	public void setAdmin_worktime(String admin_worktime) {
		this.admin_worktime = admin_worktime;
	}
	public Date getAdmin_lastlogin() {
		return admin_lastlogin;
	}
	public void setAdmin_lastlogin(Date admin_lastlogin) {
		this.admin_lastlogin = admin_lastlogin;
	}
	public String getAdmin_score() {
		return admin_score;
	}
	public void setAdmin_score(String admin_score) {
		this.admin_score = admin_score;
	}


}
