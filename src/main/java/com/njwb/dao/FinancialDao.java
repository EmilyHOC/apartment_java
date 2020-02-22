package com.njwb.dao;

import com.njwb.entity.Financial;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface FinancialDao {
    /*获取所有的财务管理列表*/
    List<Financial> getAllFinancialList();
}
