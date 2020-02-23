package com.njwb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njwb.dao.RendDao;
import com.njwb.entity.Device;
import com.njwb.entity.Rend;
import com.njwb.service.RendService;
@Service
public class RendServiceImpl implements RendService{
	@Autowired
	private RendDao dao;
	/*获取所有租赁信息*/
	@Override
	public List<Rend> getAllRend() {
		List<Rend> rendList = new ArrayList<Rend>();
		rendList = dao.queryAllRend();
		return rendList;
	}
	/*搜索合同*/
	@Override
	public List<Rend> searchRendInfo(String rend_Id) {
		List<Rend> rendList = new ArrayList<Rend>();
		rendList = dao.searchRendById(rend_Id);
		return rendList;
	}
	//退租
	@Override
	public void deleteRend(String rend_Id) {
		 dao.deleteRend(rend_Id);
	}
	//续租
	@Override
	public void modifyRendEnd(String rend_end, String rend_Id) {
		dao.modifyRendEnd(rend_end, rend_Id);	
	}
}
