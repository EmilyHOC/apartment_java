package com.njwb.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.njwb.dao.AdminDao;
import com.njwb.entity.Admin;
import com.njwb.exception.VoteException;
import com.njwb.service.AdminService;
@Service
public class AdminServiceImpl  implements AdminService{
	@Autowired
	private AdminDao dao;
	/**
	 * 登录
	 * @param admin
	 * @throws VoteException
	 */
	@SuppressWarnings("unused")
	@Override
	public Admin login(Admin admin) throws VoteException {
		Admin res = new Admin();
		
			if(dao.queryByAdminName(admin.getAdmin_name()) == null) {
				throw new VoteException("用户账号不存在！");
			}else {
				/*用户存在，并且查询结果不为空*/
				if(dao.query(admin)!= null){
					/*查询所有管理员并且用户名密码匹配*/
					res = dao.query(admin);
				}else {
					throw new VoteException("用户密码错误！");
					
				}
				
				//这样处理时错误的	
//					if(res == null) {
//						System.out.println("用户密码错误！");
//						
//					}
			} 
			
	
		return res;
	}
	/*
	 * 查询所有管理员
	 */
	@Override
	public List<Admin> getAllAdmin() {
		List<Admin> adminList = new ArrayList<Admin>();
		adminList = dao.getAllAdmin();
		return adminList;
	}
	/*
	 * 删除管理员
	 * */
	@Override
	public void deleteAdmin(Integer adminId) {
		dao.deleteAdmin(adminId);
	}
	/*
	 * 新增管理员
	 * */
	@Override
	public void addNewAdmin(Admin admin) {
		dao.addNewAdmin(admin);
	}
	/*
	 * 修改管理员信息
	 * */
	@Override
	public void modifyAdmin(Admin admin) {
		dao.modifyAdmin(admin);
	}
	/*
	 * 根据管理员的名字搜索
	 * */
	@Override
	public List<Admin> queryByAdminName(String admin_realname){
		List<Admin> adminList = new ArrayList<Admin>();
		adminList = dao.queryByAdminName(admin_realname);
		return adminList;
	}
}
