package com.njwb.service;

import java.util.List;

import com.njwb.entity.Rend;

public interface RendService {
	/*获取所有租赁信息*/
	List<Rend> getAllRend();
	//搜索合同
	List<Rend> searchRendInfo(String rend_Id);
	//退租
	void deleteRend(String rend_Id);
	//续租
	void modifyRendEnd(String rend_end, String rend_Id);
}
