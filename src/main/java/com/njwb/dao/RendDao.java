package com.njwb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.njwb.entity.Rend;

@Mapper
public interface RendDao {
	//获取所有租赁信息
	List<Rend> queryAllRend();
	//搜索
	List<Rend> searchRendById(String rend_Id);
	//退租
	void deleteRend(String rend_Id);
	//续租
	void modifyRendEnd(String rend_end, String rend_Id);
}
