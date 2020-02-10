//package com.njwb.service.impl;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import com.njwb.dao.AdminDao;
//import com.njwb.entity.Admin;
//import com.njwb.exception.VoteException;
//import com.njwb.service.AdminService;
//import com.njwb.util.VoteUtil;
//@Service
//public class AdminServiceImpl  implements AdminService{
//	@Autowired
//	private AdminDao dao;
//	/**
//	 * 登录
//	 * @param admin
//	 * @throws VoteException
//	 */
//	@Override
//	public Admin login(Admin admin) throws VoteException {
//		Admin res = new Admin();
//		try {
//			//非空判断（如果前端页面已判断，可以删除此处判断逻辑）
//			//开始
//			if(VoteUtil.isEmpty(admin.getAdmin_name())) {
//				throw new VoteException("用户账号不能为空！");
//			}
//			if(VoteUtil.isEmpty(admin.getAdmin_pwd())) {
//				throw new VoteException("用户密码不能为空！");
//			}
//			//结束
//			//首先查询账号是否存在
//			if(dao.queryByName(admin.getAdmin_name()) == null) {
//				throw new VoteException("用户账号不存在2！");
//			}
//			//其次查询密码是否正确
//
//			res = dao.query(admin);
//			if(res == null ) {
//				throw new VoteException("用户密码错误！");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return res;
//	}
//	/**
//	 * 修改用户密码
//	 * @param admin
//	 * @throws VoteException
//	 */
//	@Transactional
//	@Override
//	public void modPwd(Admin admin) throws VoteException {
//		try {
//			if(dao.queryByName(admin.getAdmin_name()) == null) {
//				throw new VoteException("用户账号不存在！");
//			}
//			dao.mod(admin);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	@Override
//	public List<Admin> getAllAdmin() {
//		List<Admin> adminList = new ArrayList<Admin>();
//		adminList = dao.getAllAdmin();
//		return adminList;
//	}
//	
//	@Override
//	public void registAdmin(Admin admin) throws VoteException{
//		try {
//			if(dao.queryByName(admin.getAdmin_name()) != null) {
//				throw new VoteException("用户账号已存在！");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		dao.adminRegist(admin);
//	}
//	
//	@Override
//	public List<Admin> getAllUser() throws VoteException {
//		List<Admin> adminList = new ArrayList<Admin>();
//		adminList = dao.getAllUser();
//		return adminList;
//	}
//	
//	@Override
//	public void updateUser(Admin admin) throws VoteException {
//		dao.updateUser(admin);
//	}
//	@Override
//	public void removeUser(Admin admin) throws VoteException {
//		dao.removeUser(admin);
//		
//	}
//}
