package com.njwb.entity;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter@ToString
public class Vote {
	private int id;
	private String user_id; //发起人用户名
	private String vote_name;  //投票名称
	private String vote_messages;  //投票信息，这个需要单独解析
	private int status; //状态 2为进行中 9为暂停
	private Date create_time;
	private Date end_time;
}
