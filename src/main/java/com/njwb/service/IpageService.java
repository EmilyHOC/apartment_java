package com.njwb.service;

import java.util.List;

import com.njwb.entity.Room;

public interface IpageService {
	//page表示当前页数，limit表示用户设置的每页显示多少条数据
    List<Room> getRooms(Integer page, Integer limit);
    
}
