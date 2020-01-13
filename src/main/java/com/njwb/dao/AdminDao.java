package com.njwb.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.njwb.entity.Admin;
/**
 * 管理员接口
 * @author meng
 *
 */
@Mapper
public interface AdminDao {
	/**
	 * 根据管理员账号查询
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	Admin queryByName(String name) throws SQLException;
	/**
	 * 根据管理员账号和密码查询
	 * @param admin
	 * @return
	 * @throws SQLException
	 */
	Admin query(Admin admin) throws SQLException;
	/**
	 * 修改管理员密码
	 * @param admin
	 * @return
	 * @throws SQLException
	 */
	int mod(Admin admin)throws SQLException;
	
	/**
	 * 获得所有管理员
	 * @return 
	 */
	List<Admin> getAllAdmin();
	
	/**
	 * 管理员注册
	 * @param admin 
	 */
	void adminRegist(Admin admin);
	
	/**
	 * 获得所有用户
	 * @return
	 */
	List<Admin> getAllUser();
	
	
	/**
	 * 管理员修改用户信息
	 * @param admin
	 */
	void updateUser(Admin admin);
	
	/**
	 * 注销用户
	 * @param admin
	 */
	void removeUser(Admin admin);
}
