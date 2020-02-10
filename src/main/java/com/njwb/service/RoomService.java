package com.njwb.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.njwb.entity.Room;
import com.njwb.entity.User;
import com.njwb.exception.VoteException;


public interface RoomService {


	List<Room> queryRoomAll()throws VoteException ;
	 
	void deleteRoom(int i);
	
	List<Room> queryRoomByAddress(String room_address) throws  SQLException, VoteException;

	void addNewRoom(Room room);

	void modifyRoom(Room room, int roomid);

}
