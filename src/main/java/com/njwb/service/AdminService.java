package com.njwb.service;

import java.util.List;

import com.njwb.entity.Admin;
import com.njwb.exception.VoteException;


public interface AdminService {
	//登录
	Admin login(Admin admin)throws VoteException;
	//查询所有
	List<Admin> getAllAdmin();
	//删除管理员
	void deleteAdmin(Integer adminId) throws VoteException;
	//新增管理员
	void addNewAdmin(Admin admin);
	//更改管理员信息
	void modifyAdmin(Admin admin);
	//根据名字模糊查询
	List<Admin> queryByAdminName(String admin_realname);
}
