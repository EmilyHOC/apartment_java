package com.njwb.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.njwb.entity.User;
/**
 * 用户接口
 * @author meng
 *
 */
@Mapper
public interface UserDao {
	/**
	 * 新增用户
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	int add(User user)throws SQLException;
	/**
	 * 删除用户
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	int del(int id)throws SQLException;
	/**
	 * 修改用户
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	int mod(User user)throws SQLException;
	/**
	 * 根据用户账号查询用户
	 * @param user_id
	 * @return
	 * @throws SQLException
	 */
	User queryByUserId(String user_id)throws SQLException;
	/**
	 * 根据用户Id查询用户
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	User queryById(int id)throws SQLException;
	/**
	 * 查询所有用户
	 * @return
	 * @throws SQLException
	 */
	List<User> queryAll()throws SQLException;
	/**
	 * 根据用户名模糊查询
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	List<User> queryLikeName(String name)throws SQLException;
}
