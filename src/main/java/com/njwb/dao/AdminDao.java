package com.njwb.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.njwb.entity.Admin;

@Mapper
public interface AdminDao {
//	/*根据名字查询*/
//	Admin queryByAdminName(String name) throws SQLException;
//	
	/*查询所有管理员*/
	List<Admin> getAllAdmin();
	/*删除管理员*/
	void deleteAdmin(Integer adminId);
	/*添加管理员*/
	void addNewAdmin(Admin admin);
	/*修改管理员*/
	void modifyAdmin(Admin admin);
	/*根据名字修改*/
	List<Admin> queryByAdminName(String admin_realname);
	Admin queryAllAdmin(Admin admin);
	/*判断用户名密码是不是匹配*/
	Admin query(Admin admin);
}
