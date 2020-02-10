package com.njwb.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.njwb.entity.Room;
import com.njwb.entity.User;

@Mapper
public interface RoomDao {
	//删除房源 
	void deleteRoom(int id);
	//根据地址查找房源
	List<Room> queryRoomByAddress(@Param("room_address")String room_address);
	//新增房源
	int addNewRoom(Room room);
	//修改房源信息
	void modifyRoom(@Param("room")Room room, @Param("roomid")Integer roomid);
	List<Room> queryRoomAll();
}
