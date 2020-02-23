package com.njwb.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter@ToString
public class Rend {
	private int rend_Id; //合同id
	private String rend_address; //地址
	private String  rend_man; //租赁人
	private String rend_contract; //联系方式
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date rend_start; //合同开始时间
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private String rend_end; //结束时间
	public int getRend_Id() {
		return rend_Id;
	}
	public void setRend_Id(int rend_Id) {
		this.rend_Id = rend_Id;
	}
	public String getRend_address() {
		return rend_address;
	}
	public void setRend_address(String rend_address) {
		this.rend_address = rend_address;
	}
	public String getRend_man() {
		return rend_man;
	}
	public void setRend_man(String rend_man) {
		this.rend_man = rend_man;
	}
	public String getRend_contract() {
		return rend_contract;
	}
	public void setRend_contract(String rend_contract) {
		this.rend_contract = rend_contract;
	}
	public Date getRend_start() {
		return rend_start;
	}
	public void setRend_start(Date rend_start) {
		this.rend_start = rend_start;
	}
	public String getRend_end() {
		return rend_end;
	}
	public void setRend_end(String rend_end) {
		this.rend_end = rend_end;
	}
	
}

