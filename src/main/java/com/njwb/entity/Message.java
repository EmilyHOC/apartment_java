package com.njwb.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter@ToString
public class Message {
	private int option_id;
	private String option_name;
	private int option_num;
	private List<String> option_user;
	
	public Message(int option_id,String option_name, int option_num, List<String> option_user) {
		super();
		this.option_id = option_id;
		this.option_name = option_name;
		this.option_num = option_num;
		this.option_user = option_user;
	}
	
	public void vote() {
		this.option_num++;
		//this.option_user.add("q");
	}
}
