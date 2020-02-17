package com.njwb.service;


import com.njwb.entity.Custom;

import java.util.List;

public interface CustomService {
    //查询所有客户列表
    List<Custom> getAllCustom();
    //删除客户
    void deleteCustom(Integer customId);

    List<Custom> searchCustomByAdminName(String custom_name);
}
