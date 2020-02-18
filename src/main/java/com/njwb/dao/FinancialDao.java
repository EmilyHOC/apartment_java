package com.njwb.dao;

import com.njwb.entity.Financial;

import java.util.List;

public interface FinancialDao {
    /*获取所有的财务管理列表*/
    List<Financial> getAllFinancialList();
}
