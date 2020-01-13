package com.njwb.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;
import com.njwb.entity.Admin;
import com.njwb.entity.Return;
import com.njwb.entity.Message;
import com.njwb.exception.VoteException;
import com.njwb.service.AdminService;

@RestController
public class AdminController {
	@Autowired
	private AdminService adminService;
	/**
	 * 测试服务是否开启
	 * @return
	 */
	@RequestMapping(value="/test",method=RequestMethod.GET) @CrossOrigin("*") 
	public Object test() {
		return "connected";
	}
	
	@RequestMapping(value="/t",method=RequestMethod.GET) @CrossOrigin("*") 
	public Object index() {
		ArrayList<Message> messages = new ArrayList<Message>();
		ArrayList<String> aaa= new ArrayList<String>();
		messages.add(new Message(0,"选项一",0,aaa));
		messages.add(new Message(1,"选项二",0,aaa));
		return JSONObject.toJSON(messages).toString();
	}
	
	
//	@RequestMapping(value="/admin/login",method=RequestMethod.GET)
//	public Object login() {
//		return "admin/login";
//	}


	/**
	 * 处理登录表单
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/api/admin/login",method=RequestMethod.POST) @CrossOrigin("*") 
	public Object loginFrom(HttpServletRequest request,@RequestBody  Admin admin,HttpSession session) {
//		String admin_name = request.getParameter("admin_name");
//		String admin_pwd = request.getParameter("admin_pwd");
//		Admin admin = new Admin();
//		admin.setAdmin_name(admin_name);
//		admin.setAdmin_pwd(admin_pwd);
		try {
			//管理员登录
			return JSONObject.toJSON(new Return<Admin>(0,"success",adminService.login(admin)));
			
		} catch (VoteException e) {
			session.setAttribute("adminError", e.getMessage());//将错误信息保存在session
			return JSONObject.toJSON(new Return<Integer>(1,e.getMessage(),0));
		}
	}
	
	@RequestMapping(value="/api/admin/modPwd",method=RequestMethod.POST) @CrossOrigin("*") 
	public Object ModAdmin(HttpServletRequest request,@RequestBody  Admin admin,HttpSession session) {
		try {
			adminService.modPwd(admin);
			Return<Integer> re = new Return<Integer>(0,0);
			return re;
		} catch (VoteException e) {
			session.setAttribute("adminError", e.getMessage());//将错误信息保存在session
			return JSONObject.toJSON(new Return<Integer>(1,e.getMessage(),0));
		}
	}
	
	
	@RequestMapping("/api/admin/getAll") @CrossOrigin("*") 
	public Object getAllAdmin() throws VoteException {
		Return<List<Admin>> re = new Return<List<Admin>>(0,adminService.getAllAdmin());
		return re;	
	}
	
	@RequestMapping("/api/admin/getAllUser") @CrossOrigin("*") 
	public Object getAllUser() throws VoteException {
		Return<List<Admin>> re = new Return<List<Admin>>(0,adminService.getAllUser());
		return re;	
	}
	
	@RequestMapping("/api/admin/register") @CrossOrigin("*") 
	public Object registUser(@RequestBody Admin admin) throws VoteException {
		try {
			adminService.registAdmin(admin);
		} catch (VoteException e) {
			return JSONObject.toJSON(new Return<Integer>(1,e.getMessage(),0));
		}
		Return<Admin> re = new Return<Admin>(0,admin);
		return re;
	}
	
	@RequestMapping(value="/api/admin/updateUser",method=RequestMethod.POST) @CrossOrigin("*") 
	public Object updateUser(HttpServletRequest request,@RequestBody  Admin admin,HttpSession session) {
		try {
			adminService.updateUser(admin);
			Return<Integer> re = new Return<Integer>(0,0);
			return re;
		} catch (VoteException e) {
			session.setAttribute("adminError", e.getMessage());//将错误信息保存在session
			return JSONObject.toJSON(new Return<Integer>(1,e.getMessage(),0));
		}
	}
	
	@RequestMapping(value="/api/admin/remove",method=RequestMethod.POST) @CrossOrigin("*") 
	public Object removeUser(HttpServletRequest request,@RequestBody  Admin admin,HttpSession session) {
		try {
			adminService.removeUser(admin);
			Return<Integer> re = new Return<Integer>(0,0);
			return re;
		} catch (VoteException e) {
			session.setAttribute("adminError", e.getMessage());//将错误信息保存在session
			return JSONObject.toJSON(new Return<Integer>(1,e.getMessage(),0));
		}
	}
	
}
