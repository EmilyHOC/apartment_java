package com.njwb.dao;

import com.njwb.entity.Custom;

import java.util.List;


public interface CustomDao {
    //查询所有客户信息
    List<Custom> getAllCustom();
    //删除客户信息
    void deleteCustom(Integer customId);
    //根据名字搜索客户
    void searchCustomByAdminName(String custom_name);
}
