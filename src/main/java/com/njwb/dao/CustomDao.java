package com.njwb.dao;

import com.njwb.entity.Custom;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomDao {
    //查询所有客户信息
    List<Custom> getAllCustom();
    //删除客户信息
    void deleteCustom(Integer customId);
    //根据名字搜索客户
    void searchCustomByAdminName(String custom_name);
    //修改客户信息
    void modifyCustom(Custom custom);
    //新增客户
    void addNewCustom(Custom custom);
}
