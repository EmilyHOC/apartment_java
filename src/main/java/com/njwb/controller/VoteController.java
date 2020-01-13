package com.njwb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;
import com.njwb.entity.Return;
import com.njwb.entity.User;
import com.njwb.entity.Vote;
import com.njwb.exception.VoteException;
import com.njwb.service.VoteService;

@RestController
public class VoteController {
	@Autowired
	private VoteService voteService;
	

	@RequestMapping("/api/vote/create") @CrossOrigin("*") 
	public Object createVote(@RequestBody Vote vote) throws VoteException {
		try {
			long t1 = System.currentTimeMillis();
			if(t1 < vote.getEnd_time().getTime()&& t1 >=vote.getCreate_time().getTime())
			{
				vote.setStatus(2);
			}
			else {
				vote.setStatus(9);
			}
			voteService.createVote(vote);
			voteService.updateStatus();
			Return<List<Vote>> re = new Return<List<Vote>>(0,voteService.queryVoteAll());
			return re;
		} catch (VoteException e) {
			return JSONObject.toJSON(new Return<Integer>(1,e.getMessage(),0));
		}
	}
	
	
	@RequestMapping("/api/vote/modify") @CrossOrigin("*") 
	public Object modifyVote(@RequestBody Vote vote) throws VoteException {
		try {
			voteService.modifyVote(vote);
			Return<Integer> re = new Return<Integer>(0,0);
			return re;
		} catch (VoteException e) {
			return JSONObject.toJSON(new Return<Integer>(1,e.getMessage(),0));
		}
	}

	@RequestMapping("/api/vote/delete") @CrossOrigin("*") 
	public Object deleteVote(@RequestBody Vote vote) throws VoteException {
		try {
			voteService.deleteVote(vote.getId());
			Return<Integer> re = new Return<Integer>(0,0);
			return re;
		} catch (VoteException e) {
			return JSONObject.toJSON(new Return<Integer>(1,e.getMessage(),0));
		}
	}
	
	
	@RequestMapping("/api/vote/getAll") @CrossOrigin("*") 
	public Object getAllVote() throws VoteException {
		try {
			voteService.updateStatus();
			Return<List<Vote>> re = new Return<List<Vote>>(0,voteService.queryVoteAll());
			return re;
		} catch (VoteException e) {
			return JSONObject.toJSON(new Return<Integer>(1,e.getMessage(),0));
		}
	}
	
	@RequestMapping("/api/vote/getByUser") @CrossOrigin("*") 
	public Object getVoteByUser(@RequestBody User user) throws VoteException {
		try {
			Return<List<Vote>> re = new Return<List<Vote>>(0,voteService.queryVoteListByUserId(user.getUser_id()));
			return re;
		} catch (VoteException e) {
			return JSONObject.toJSON(new Return<Integer>(1,e.getMessage(),0));
		}
	}
	
	//模糊查找
	@RequestMapping("/api/vote/getByName") @CrossOrigin("*") 
	public Object getVoteByName(@RequestBody HashMap<String,String> key) throws VoteException {
		try {
			Return<List<Vote>> re = new Return<List<Vote>>(0,voteService.queryByName(key.get("key")));
			return re;
		} catch (VoteException e) {
			return JSONObject.toJSON(new Return<Integer>(1,e.getMessage(),0));
		}
	}
	
	@RequestMapping("/api/vote/getNow") @CrossOrigin("*") 
	public Object getVoteListNow() throws VoteException {
		try {
			Return<List<Vote>> re = new Return<List<Vote>>(0,voteService.queryVoteListNow());
			return re;
		} catch (VoteException e) {
			return JSONObject.toJSON(new Return<Integer>(1,e.getMessage(),0));
		}
	}
	
	
	@RequestMapping("/api/vote/getFinish") @CrossOrigin("*") 
	public Object getVoteFinish() throws VoteException {
		try {
			Return<List<Vote>> re = new Return<List<Vote>>(0,voteService.queryVoteListHistory());
			return re;
		} catch (VoteException e) {
			return JSONObject.toJSON(new Return<Integer>(1,e.getMessage(),0));
		}
	}
	
	@RequestMapping("/api/vote/getByUserNow") @CrossOrigin("*") 
	public Object getVoteByUserNow(@RequestBody User user) throws VoteException {
		try {
			Return<List<Vote>> re = new Return<List<Vote>>(0,voteService.queryVoteListNowByUserId(user.getUser_id()));
			return re;
		} catch (VoteException e) {
			return JSONObject.toJSON(new Return<Integer>(1,e.getMessage(),0));
		}
	}


	@RequestMapping("/api/vote/getByUserFinish") @CrossOrigin("*") 
	public Object getVoteByUserFinish(@RequestBody User user) throws VoteException {
		try {
			Return<List<Vote>> re = new Return<List<Vote>>(0,voteService.queryVoteListHistoryByUserId(user.getUser_id()));
			return re;
		} catch (VoteException e) {
			return JSONObject.toJSON(new Return<Integer>(1,e.getMessage(),0));
		}
	}
	
	@RequestMapping("/api/vote/searchByName") @CrossOrigin("*") 
	public Object searchByName(@RequestBody Vote vote) throws VoteException {
		try {
			Return<Vote> re = new Return<Vote>(0,voteService.queryVoteByNameAndStatus(vote.getVote_name()));
			return re;
		} catch (VoteException e) {
			return JSONObject.toJSON(new Return<Integer>(1,e.getMessage(),0));
		}
	}
	
	@RequestMapping("/api/vote/voteOne") @CrossOrigin("*") 
	public Object voteOne(@RequestBody Map<String, String> data) throws VoteException {
		try {
			voteService.voteOne(data);	
			Return<Integer> re = new Return<Integer>(0,0);
			return re;
		} catch (VoteException e) {
			return JSONObject.toJSON(new Return<Integer>(1,e.getMessage(),0));
		}
	}	
	
}
