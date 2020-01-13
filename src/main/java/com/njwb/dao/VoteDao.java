package com.njwb.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.njwb.entity.Vote;
/**
 * 管理投票接口
 * @author meng
 *
 */
@Mapper
public interface VoteDao {
	/**
	 * 添加投票
	 * @param vote
	 * @return
	 * @throws SQLException
	 */
	int add(Vote vote)throws SQLException;
	/**
	 * 删除投票
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	int del(int id)throws SQLException;
	/**
	 * 修改投票
	 * @param vote
	 * @return
	 * @throws SQLException
	 */
	int mod(Vote vote)throws SQLException;
	/**
	 * 根据id查询投票
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	Vote queryById(int id)throws SQLException;
	/**
	 * 根据用户id查询投票列表
	 * @param user_id
	 * @return
	 * @throws SQLException
	 */
	List<Vote> queryByUserId(String user_id)throws SQLException;
	/**
	 * 根据投票名称模糊查询
	 * @param vote_name
	 * @return
	 * @throws SQLException
	 */
	List<Vote> queryByName(String vote_name)throws SQLException;
	/**
	 * 查询所有投票
	 * @return
	 * @throws SQLException
	 */
	List<Vote> queryAll()throws SQLException;
	/**
	 * 查询正在进行中的所有投票
	 * @return
	 * @throws SQLException
	 */
	List<Vote> queryVoteListNow()throws SQLException;
	/**
	 * 查询已经结束的所有投票
	 * @return
	 * @throws SQLException
	 */
	List<Vote> queryVoteListHistory()throws SQLException;
	
	/**
	 * 查询正在进行中的当前用户的所有投票
	 * @param user_id
	 * @return
	 * @throws SQLException
	 */
	List<Vote> queryVoteListNowByUserId(String user_id)throws SQLException;
	
	/**
	 * 查询已经结束的当前用户的所有投票
	 * @param user_id
	 * @return
	 * @throws SQLException
	 */
	List<Vote> queryVoteListHistoryByUserId(String user_id)throws SQLException;
	/**
	 * 根据发起投票的名称和状态查询当前投票是否正在进行 2为正在进行  9已经结束
	 * @param vote_name
	 * @return
	 * @throws SQLException
	 */
	Vote queryByNameAndStatus(String vote_name)throws SQLException;
}
