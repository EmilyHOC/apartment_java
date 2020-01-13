package com.njwb.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.njwb.entity.Vote;
import com.njwb.exception.VoteException;
/**
 * 投票业务接口
 * @author meng
 *
 */
@Service
public interface VoteService {
	/**
	 * 创建投票
	 * @param vote
	 * @throws VoteException
	 */
	void createVote(Vote vote)throws VoteException;
	/**
	 * 修改投票
	 * @param vote
	 * @throws VoteException
	 */
	void modifyVote(Vote vote)throws VoteException;
	/**
	 * 删除投票
	 * @param id
	 * @throws VoteException
	 */
	void deleteVote(int id)throws VoteException;
	/**
	 * 查询所有投票
	 * @return
	 * @throws VoteException
	 */
	List<Vote> queryVoteAll()throws VoteException;
	/**
	 * 根据用户账号查询所有投票
	 * @param user_id
	 * @return
	 * @throws VoteException
	 */
	List<Vote> queryVoteListByUserId(String user_id)throws VoteException;
	/**
	 * 根据投票名称模糊查询
	 * @param vote_name
	 * @return
	 * @throws VoteException
	 */
	List<Vote> queryByName(String vote_name)throws VoteException;
	/**
	 * 查询正在进行中的所有投票
	 * @return
	 * @throws VoteException
	 */
	List<Vote> queryVoteListNow()throws VoteException;
	/**
	 * 查询所有已经结束的投票
	 * @return
	 * @throws VoteException
	 */
	List<Vote> queryVoteListHistory()throws VoteException;
	/**
	 * 根据用户账号查询当前用户创建的所有投票
	 * @param user_id
	 * @return
	 * @throws VoteException
	 */
	List<Vote> queryVoteListNowByUserId(String user_id)throws  VoteException;
	/**
	 * 根据用户账号查询当前用户已经结束的所有投票
	 * @param user_id
	 * @return
	 * @throws VoteException
	 */
	List<Vote> queryVoteListHistoryByUserId(String user_id)throws  VoteException;
	/**
	 * 根据发起投票的名称和状态查询当前投票是否正在进行 2为正在进行  9已经结束
	 * @param vote_name
	 * @return
	 * @throws VoteException
	 */
	Vote queryVoteByNameAndStatus(String vote_name)throws VoteException;
	/**
	 * 投一票的具体实现
	 * @param data
	 * @throws VoteException
	 */
	void voteOne(Map<String, String> data) throws VoteException;
	
	
	/**
	 * 更新表中所有投票的status信息
	 */
	void updateStatus();
}
