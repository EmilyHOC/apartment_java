package com.njwb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.njwb.entity.User;
import com.njwb.exception.VoteException;

/**
 * 用户业务接口
 * @author meng
 *
 */
@Service
public interface UserService {
	/**
	 * 用户登录
	 * @param user
	 * @throws VoteException
	 */
	void loginUser(User user)throws VoteException;
	/**
	 * 用户注册
	 * @param user
	 * @throws VoteException
	 */
	void registUser(User user)throws VoteException;
	/**
	 * 用户注销
	 * @param id
	 * @throws VoteException
	 */
	void cancelUser(int id)throws VoteException;
	/**
	 * 修改用户信息
	 * @param user
	 * @throws VoteException
	 */
	void modifyUserInfo(User user)throws VoteException;
	/**
	 * 查询所有用户
	 * @return
	 * @throws VoteException
	 */
	List<User> queryUserAll()throws VoteException;
	/**
	 * 根据用户名模糊查询
	 * @param name
	 * @return
	 * @throws VoteException
	 */
	List<User> queryUserByLikeUserName(String name)throws VoteException;
}
