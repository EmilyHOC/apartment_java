package com.njwb.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;
import com.njwb.entity.Return;
import com.njwb.entity.User;
import com.njwb.exception.VoteException;
import com.njwb.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/api/user/login") @CrossOrigin("*") 
	public Object loginUser(@RequestBody User user) throws VoteException {
		try {
			userService.loginUser(user);
			Return<Integer> re = new Return<Integer>(0,0);
			return re;
		} catch (VoteException e) {
			return JSONObject.toJSON(new Return<Integer>(1,e.getMessage(),0));
		}
	}
	
	@RequestMapping("/api/user/regist") @CrossOrigin("*") 
	public Object registUser(@RequestBody User user) throws VoteException {
		try {
			userService.registUser(user);
			Return<Integer> re = new Return<Integer>(0,0);
			return re;
		} catch (VoteException e) {
			return JSONObject.toJSON(new Return<Integer>(1,e.getMessage(),0));
		}
	}
	
	@RequestMapping("/api/user/del") @CrossOrigin("*") 
	public Object cancelUser(@RequestBody User user) throws VoteException {
		try {
			userService.cancelUser(user.getId());
			Return<Integer> re = new Return<Integer>(0,0);
			return re;
		} catch (VoteException e) {
			return JSONObject.toJSON(new Return<Integer>(1,e.getMessage(),0));
		}
	}
	

	@RequestMapping("/api/user/modify") @CrossOrigin("*") 
	public Object modifyUser(@RequestBody User user) throws VoteException {
		try {
			userService.modifyUserInfo(user);
			Return<Integer> re = new Return<Integer>(0,0);
			return re;
		} catch (VoteException e) {
			return JSONObject.toJSON(new Return<Integer>(1,e.getMessage(),0));
		}
	}
	
	@RequestMapping("/api/user/getAll") @CrossOrigin("*") 
	public Object queryUser() throws VoteException {
		try {
			Return<List<User>> re = new Return<List<User>>(0,userService.queryUserAll());
			return re;
		} catch (VoteException e) {
			return JSONObject.toJSON(new Return<Integer>(1,e.getMessage(),0));
		}
	}
	
	@RequestMapping("/api/user/Search") @CrossOrigin("*") 
	public Object searchUser(@RequestBody HashMap<String,String> key) throws VoteException {
		try {
			
			Return<List<User>> re = new Return<List<User>>(0,userService.queryUserByLikeUserName(key.get("key")));
			return re;
		} catch (VoteException e) {
			return JSONObject.toJSON(new Return<Integer>(1,e.getMessage(),0));
		}
	}
}
	