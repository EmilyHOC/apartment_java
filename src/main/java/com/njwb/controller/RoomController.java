package com.njwb.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;
import com.njwb.entity.Return;
import com.njwb.entity.Room;
import com.njwb.exception.VoteException;
import com.njwb.service.RoomService;
@RestController
public class RoomController {
	@Autowired
	private RoomService roomService;
	//查询所有房源
	@RequestMapping("/api/room/getAll") @CrossOrigin("*") 
	public Object queryRoom() throws VoteException {
		try {
			Return<List<Room>> re = new Return<List<Room>>(0,roomService.queryRoomAll());
			return re;
		} catch (VoteException e) {
			return JSONObject.toJSON(new Return<Integer>(1,e.getMessage(),0));
		}
	}
	//根据id删除房源
	@RequestMapping(value = "/api/room/deleteRoom", method = RequestMethod.DELETE) @CrossOrigin("*") 
	public Object deleteRoom(@RequestParam("roomid") Integer roomid) throws VoteException{
		roomService.deleteRoom(roomid);
		Return<Integer> re = new Return<Integer>(0,0);
		return re;
	}
	//新增房源
	@RequestMapping(value = "/api/room/addNewRoom") @CrossOrigin("*") 
	public Object addNewRoom(HttpServletRequest req) throws VoteException {
		String room_address = req.getParameter("room_address");
		int room_usage = Integer.parseInt(req.getParameter("room_usage"));
		double room_area = Double.parseDouble(req.getParameter("room_area"));
		int room_rend =  Integer.parseInt(req.getParameter("room_rend"));
		String create_time = req.getParameter("create_time");
		String remarks = req.getParameter("remarks");
		Room room1 = new Room();
		room1.setRoom_address(room_address);
		room1.setRoom_usage(room_usage);
		room1.setRoom_area(room_area);
		room1.setRoom_rend(room_rend);
		room1.setRemarks(remarks);
		room1.setCreate_time(create_time);
		roomService.addNewRoom(room1);
		Return<Integer> re = new Return<Integer>(0,0);
		return re;
	}
	//修改房源信息
	@PutMapping("/api/room/modifyRoom") @CrossOrigin("*") 
	public Object modifyRoom(@RequestBody Room  room) throws VoteException {
		int roomid = room.getRoomid();
		System.out.println(roomid);
		roomService.modifyRoom(room,roomid);
		Return<Integer> re = new Return<Integer>(0,0);
		return re;
	}
	
	//根据地址查找房源 
	@RequestMapping(value="/api/room/searchRoom",method=RequestMethod.POST) @CrossOrigin("*") 
	public Object searchUser(@RequestBody Map<String,String> params) throws VoteException, SQLException {
		System.out.println("查找房源");
		String room_address = (String) params.get("key");
		System.out.println(room_address);
		Return<List<Room>> re = new Return<List<Room>>(0,roomService.queryRoomByAddress(room_address));
		return re;
	}
}
	