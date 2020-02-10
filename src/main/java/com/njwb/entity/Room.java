package com.njwb.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter@ToString
public class Room {
	private int id;         //数据库内id
	private int roomid; //房源id
	private String room_address; //地址
	private int room_usage; //使用年年限
	private double room_area; //房源面积
	private int room_rend; //租赁状态
	private String create_time; //创建时间
	private String remarks; //备注
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoomid() {
		return roomid;
	}
	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}
	public String getRoom_address() {
		return room_address;
	}
	public void setRoom_address(String room_address) {
		this.room_address = room_address;
	}
	public int getRoom_usage() {
		return room_usage;
	}
	public void setRoom_usage(int room_usage) {
		this.room_usage = room_usage;
	}
	public double getRoom_area() {
		return room_area;
	}
	public void setRoom_area(double room_area) {
		this.room_area = room_area;
	}
	public int getRoom_rend() {
		return room_rend;
	}
	public void setRoom_rend(int room_rend) {
		this.room_rend = room_rend;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
	
	
}
