package com.njwb.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.njwb.dao.VoteDao;
import com.njwb.entity.Message;
import com.njwb.entity.Vote;
import com.njwb.exception.VoteException;
import com.njwb.service.VoteService;
/**
 * 投票业务接口实现类
 * @author meng
 *
 */
@Service
public class VoteServiceImpl implements VoteService{
	@Autowired
	private VoteDao dao;
	/**
	 * 创建投票
	 * @param vote
	 * @throws VoteException
	 */
	@Transactional
	@Override
	public void createVote(Vote vote) throws VoteException {
		try {
			//查询投票是否正在进行
			if(dao.queryByNameAndStatus(vote.getVote_name()) != null) {
				throw new VoteException("当前投票正在进行");
			}
			dao.add(vote);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 修改投票
	 * @param vote
	 * @throws VoteException
	 */
	@Transactional
	@Override
	public void modifyVote(Vote vote) throws VoteException {
		try {
			dao.mod(vote);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 删除投票
	 * @param id
	 * @throws VoteException
	 */
	@Transactional
	@Override
	public void deleteVote(int id) throws VoteException {
		try {
			dao.del(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 查询所有投票
	 * @return
	 * @throws VoteException
	 */
	@Override
	public List<Vote> queryVoteAll() throws VoteException {
		List<Vote> voteList = new ArrayList<Vote>();
		try {
			voteList = dao.queryAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return voteList;
	}
	/**
	 * 根据用户账号查询所有投票
	 * @param user_id
	 * @return
	 * @throws VoteException
	 */
	@Override
	public List<Vote> queryVoteListByUserId(String user_id) throws VoteException {
		List<Vote> voteList = new ArrayList<Vote>();
		try {
			voteList = dao.queryByUserId(user_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return voteList;
	}
	/**
	 * 根据投票名称模糊查询
	 * @param vote_name
	 * @return
	 * @throws VoteException
	 */
	@Override
	public List<Vote> queryByName(String vote_name) throws VoteException {
		List<Vote> voteList = new ArrayList<Vote>();
		try {
			voteList = dao.queryByName(vote_name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return voteList;
	}
	/**
	 * 查询正在进行中的所有投票
	 * @return
	 * @throws VoteException
	 */
	@Override
	public List<Vote> queryVoteListNow() throws VoteException {
		List<Vote> voteList = new ArrayList<Vote>();
		try {
			voteList = dao.queryVoteListNow();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return voteList;
	}
	/**
	 * 查询所有已经结束的投票
	 * @return
	 * @throws VoteException
	 */
	@Override
	public List<Vote> queryVoteListHistory() throws VoteException {
		List<Vote> voteList = new ArrayList<Vote>();
		try {
			voteList = dao.queryVoteListHistory();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return voteList;
	}
	/**
	 * 根据用户账号查询当前用户创建的进行中投票
	 * @param user_id
	 * @return null
	 * @throws VoteException
	 */
	@Override
	public List<Vote> queryVoteListNowByUserId(String user_id) throws VoteException {
		List<Vote> voteList = new ArrayList<Vote>();
		try {
			voteList = dao.queryVoteListNowByUserId(user_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return voteList;
	}
	/**
	 * 根据用户账号查询当前用户已经结束的所有投票
	 * @param user_id
	 * @return
	 * @throws VoteException
	 */
	@Override
	public List<Vote> queryVoteListHistoryByUserId(String user_id) throws VoteException {
		List<Vote> voteList = new ArrayList<Vote>();
		try {
			voteList = dao.queryVoteListHistoryByUserId(user_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return voteList;
	}
	/**
	 * 根据发起投票的名称和状态查询当前投票是否正在进行 2为正在进行  9已经结束
	 * @param vote_name
	 * @return
	 * @throws VoteException
	 */
	@Override
	public Vote queryVoteByNameAndStatus(String vote_name) throws VoteException {
		Vote vote = null;
		try {
			vote = dao.queryByNameAndStatus(vote_name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vote;
	}
	
	/**
	 * 投一票的具体实现
	 * 
	 */
public void voteOne(Map<String, String> data) throws VoteException{
	Vote vote = null;
	try {
		vote = dao.queryByNameAndStatus(data.get("vote_name"));
	} catch (SQLException e) {
		e.printStackTrace();
	}
	if(vote == null) {
		throw new VoteException("投票不存在或已结束");
	}
	List<Message> messages =JSON.parseObject(vote.getVote_messages(), new TypeReference<ArrayList<Message>>(){});
	
	for(Message message:messages) {
		if((message.getOption_id()+"").equals(data.get("option_id"))) {
			message.vote();
			break;
		}
	}
	vote.setVote_messages(JSONObject.toJSON(messages).toString());
	try {
		dao.mod(vote);
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
}
	

public void updateStatus() {
	long t1 = System.currentTimeMillis();
	List<Vote> voteList = new ArrayList<Vote>();
	try {
		voteList = dao.queryAll();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	for(Vote vote:voteList) {
		if(t1 < vote.getEnd_time().getTime()&& t1 >=
				vote.getCreate_time().getTime())
		{
			vote.setStatus(2);
		}
		else {
			vote.setStatus(9);
		}
		try {
			dao.mod(vote);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}

}
