package com.njwb.service;


import com.njwb.entity.Custom;

import java.util.List;

public interface CustomService {
    //查询所有客户列表
    List<Custom> getAllCustom();
    //删除客户
    void deleteCustom(Integer customId);
    //根据客户名字搜索客户
    List<Custom> searchCustomByAdminName(String custom_name);
    //修改用户信息
    void modifyCustom(Custom custom);
    //新增客户
    void addNewCustom(Custom custom);
}
