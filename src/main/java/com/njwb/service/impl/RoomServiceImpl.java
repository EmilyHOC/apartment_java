package com.njwb.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njwb.dao.AdminDao;
import com.njwb.dao.RoomDao;
import com.njwb.entity.Admin;
import com.njwb.entity.Room;
import com.njwb.entity.User;
import com.njwb.exception.VoteException;
import com.njwb.service.IpageService;
import com.njwb.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService{
	@Autowired
	private RoomDao dao;

	//查询所有房源
	@Override
	public List<Room> queryRoomAll()throws VoteException{
		List<Room> roomList = new ArrayList<Room>();
		roomList = dao.queryRoomAll();
		return roomList;
	}


	//删除房源
	@Override
	public void deleteRoom(int id) {
		dao.deleteRoom(id);
	}
	//根据地址查找房源
	@Override
	public List<Room> queryRoomByAddress(String room_address) throws  SQLException, VoteException{
		List<Room> roomList = new ArrayList<Room>();
		roomList = dao.queryRoomByAddress(room_address);
		return roomList;
	}

	//添加房源
	@Override
	public void addNewRoom(Room room) {
		dao.addNewRoom(room);
	}
	//修改房源
	@Override
	public void modifyRoom(Room room, int roomid) {
		dao.modifyRoom(room,roomid);
		
	}	
}
