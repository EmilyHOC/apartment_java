package com.njwb.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njwb.dao.UserDao;
import com.njwb.entity.User;
import com.njwb.exception.VoteException;
import com.njwb.service.UserService;
import com.njwb.util.CheckPhone;
import com.njwb.util.VoteUtil;


@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao dao;
	/**
	 * 用户登录
	 * @param user
	 * @throws VoteException
	 */
	@Override
	public void loginUser(User user) throws VoteException {
		try {
			//非空判断（如果前端页面已判断，可以删除此处判断逻辑）
			//开始
			if(VoteUtil.isEmpty(user.getUser_id())) {
				throw new VoteException("用户账号不能为空！");
			}
			if(VoteUtil.isEmpty(user.getUser_pwd())) {
				throw new VoteException("用户密码不能为空！");
			}
			//结束
			//查询用户账户是否存在
			if(dao.queryByUserId(user.getUser_id())==null) {
				throw new VoteException("用户不存在！");
			}
			//查询密码是否正确
			if(!dao.queryByUserId(user.getUser_id()).getUser_pwd().equals(user.getUser_pwd())) {
				throw new VoteException("密码错误！");
			}
			//都没报错就直接登录跳转了
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 用户注册
	 * @param user
	 * @throws VoteException
	 */
	@Transactional
	@Override
	public void registUser(User user) throws VoteException {
		try {
			//非空判断（如果前端页面已判断，可以删除此处判断逻辑）
			//开始
			if(VoteUtil.isEmpty(user.getUser_id())) {
				throw new VoteException("注册账号不能为空！");
			}
			if(VoteUtil.isEmpty(user.getUser_name())) {
				throw new VoteException("注册姓名不能为空！");
			}
			if(VoteUtil.isEmpty(user.getUser_phone())) {
				throw new VoteException("注册手机不能为空！");
			}
			if(!CheckPhone.isPhone(user.getUser_phone())) {
				throw new VoteException("手机号码格式不正确！");
			}
			if(VoteUtil.isEmpty(user.getUser_pwd())) {
				throw new VoteException("注册密码不能为空！");
			}
			//结束
			//查询用户账户是否存在
			if(dao.queryByUserId(user.getUser_id())!=null) {
				throw new VoteException("用户已存在！");
			}
			dao.add(user);//都没报错就直接添加用户信息到数据库
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 用户注销
	 * @param id
	 * @throws VoteException
	 */
	@Transactional
	@Override
	public void cancelUser(int id) throws VoteException {
		try {
			dao.del(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 修改用户
	 * @param user
	 * @throws VoteException
	 */
	@Transactional
	@Override
	public void modifyUserInfo(User user) throws VoteException {
		try {
			if(VoteUtil.isEmpty(user.getUser_name())) {
				throw new VoteException("修改姓名不能为空！");
			}
			if(VoteUtil.isEmpty(user.getUser_phone())) {
				throw new VoteException("修改手机不能为空！");
			}
			if(!CheckPhone.isPhone(user.getUser_phone())) {
				throw new VoteException("手机号码格式不正确！");
			}
			if(VoteUtil.isEmpty(user.getUser_pwd())) {
				throw new VoteException("修改密码不能为空！");
			}
			dao.mod(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 查询所有用户
	 * @return
	 * @throws VoteException
	 */
	@Override
	public List<User> queryUserAll() throws VoteException {
		List<User> userList = new ArrayList<User>();
		try {
			userList = dao.queryAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}
	/**
	 * 根据用户名模糊查询
	 * @param name
	 * @return
	 * @throws VoteException
	 */
	@Override
	public List<User> queryUserByLikeUserName(String name) throws VoteException {
		List<User> userList = new ArrayList<User>();
		try {
			if("".equals(name)) {
				throw new VoteException("查询内容为空");
			}
			userList = dao.queryLikeName(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}
	
}
