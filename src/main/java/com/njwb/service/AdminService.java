package com.njwb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.njwb.entity.Admin;
import com.njwb.exception.VoteException;
/**
 * 管理员业务接口
 * @author meng
 *
 */
@Service
public interface AdminService {
	/**
	 * 登录
	 * @param admin
	 * @throws VoteException
	 */
	Admin login(Admin admin)throws VoteException;
	/**
	 * 修改管理员密码
	 * @param admin
	 * @throws VoteException
	 */
	void modPwd(Admin admin)throws VoteException;
	
	
	/**
	 * 获得管理员列表
	 * @return
	 */
	List<Admin> getAllAdmin();
	
	/**
	 * 管理员注册
	 * @param admin
	 * @throws VoteException 
	 */
	void registAdmin(Admin admin) throws VoteException;
	
	/**
	 * 获得所有普通用户
	 * @return
	 */
	List<Admin> getAllUser() throws VoteException;
	
	
	/**
	 * 管理员修改用户信息
	 * @param admin
	 */
	void updateUser(Admin admin) throws VoteException;
	
	/**
	 * 删除用户
	 * @param admin
	 * @throws VoteException
	 */
	void removeUser(Admin admin) throws VoteException;
}
