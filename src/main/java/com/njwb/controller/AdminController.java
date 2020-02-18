package com.njwb.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.njwb.entity.Admin;
import com.njwb.entity.Return;
import com.njwb.exception.VoteException;
import com.njwb.service.AdminService;
import com.njwb.util.CookieUtil;
import com.njwb.util.SimpleDateUtil;

@RestController
public class AdminController {
	@Autowired
	private AdminService adminService;
	/*
	 * 表单登录
	 * */
	//requestBody用来处理application/json类型
	@PostMapping(value="/api/admin/login") @CrossOrigin("*") 
	public Object loginForm(@RequestBody Map<String,String> params,HttpSession session) {
		System.out.println(params.get("admin_name")+".."+params.get("admin_password"));
		Admin admin = new Admin();
		admin.setAdmin_name(params.get("admin_name"));
		admin.setAdmin_pwd(params.get("admin_password"));
		try {
			//管理员登录
			return JSONObject.toJSON(new Return<Admin>(0,"success",adminService.login(admin)));
		} catch (VoteException e) {
			session.setAttribute("adminError", e.getMessage());//将错误信息保存在session
			return JSONObject.toJSON(new Return<Integer>(1,e.getMessage(),0));
		}
	}

	/*
	 * 查询所有用户列表
	 * */
	@RequestMapping("/api/admin/getAll") @CrossOrigin("*") 
	public Object getAllAdmin(HttpServletRequest request,HttpServletResponse response) throws VoteException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//接收客户端的Cookie集合
		Cookie [] cookies = request.getCookies();
		//分理出键值对
		Cookie cookie = CookieUtil.findCookie(cookies, "login");
		System.out.println(cookie.getValue()+"找");
		//判空操作
		if(cookie==null) {
			//第一次访问
			//创建Cookie 把时间记录起来 创造键为last 记录当前时间
			Cookie cookie1 = new Cookie("last",System.currentTimeMillis()+"");
			//设置 有效时间为1小时
			cookie1.setMaxAge(60*60);
			//添加Cookie
			response.addCookie(cookie1);
			//response.getWriter().write("你好 欢迎你登录我们！！！");
		}else{
		//不是第一次登录
		//讲我们之前放入浏览器的Cookie取出
			long lasttime = Long.parseLong(cookie.getValue());
			System.out.println(SimpleDateUtil.simpleDateUtil(new Date(lasttime))+"时间");
		}
		
		
		//Cookie cookie = new Cookie("last",System.currentTimeMillis()+"");
		Return<List<Admin>> re = new Return<List<Admin>>(0,adminService.getAllAdmin());
		return re;
	}
	
	//添加新用户
	@RequestMapping(value="/api/admin/addNewAdmin",method=RequestMethod.POST) @CrossOrigin("*") 
	public Object addNewAdmin(@RequestBody Map<String,Admin> params) throws VoteException, SQLException {
		Admin admin= (Admin) params.get("newAdminInfo");
		System.out.println(admin);
		adminService.addNewAdmin(admin);
		Return<Integer> re = new Return<Integer>(0,0);
		return re;
	
	}
	//修改管理员信息
	@PutMapping("/api/admin/modifyAdmin") @CrossOrigin("*") 
	public Object modifyRoom(@RequestBody Map<String,Admin> params) throws VoteException {
		Admin admin= (Admin)params.get("modifyAdminInfo");
		adminService.modifyAdmin(admin);
		Return<Integer> re = new Return<Integer>(0,0);
		return re;
	}
	//根据名字搜索用户
	@RequestMapping(value ="/api/admin/searchAdminByName", method=RequestMethod.POST) @CrossOrigin("*") 
	public Object getAllUser(@RequestBody Map<String,String> params) throws VoteException {
		String admin_realname = params.get("admin_realname");
		System.out.println(admin_realname);
		Admin admin = new Admin();
		admin.setAdmin_realname(params.get("admin_realname"));
		Return<List<Admin>> re = new Return<List<Admin>>(0,adminService.queryByAdminName(params.get("admin_realname")));
		return re;	
	}

	//根据id删除管理员
	@RequestMapping(value = "/api/admin/deleteAdmin", method = RequestMethod.DELETE) @CrossOrigin("*") 
	public Object deleteRoom(@RequestParam("adminId") Integer adminId) throws VoteException{
		adminService.deleteAdmin(adminId);
		Return<Integer> re = new Return<Integer>(0,0);
		return re;
	}

}
