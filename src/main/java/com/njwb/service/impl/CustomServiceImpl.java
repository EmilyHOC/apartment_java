package com.njwb.service.impl;
import com.njwb.dao.CustomDao;
import com.njwb.entity.Admin;
import com.njwb.entity.Custom;
import com.njwb.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomServiceImpl implements CustomService {
    @Autowired
    private CustomDao dao;

    @Override
    /*查询所有客户列表*/
    public List<Custom> getAllCustom() {
        List<Custom> customList = new ArrayList<Custom>();
        customList = dao.getAllCustom();
        return customList;
    }
    //删除用户
    @Override
    public void deleteCustom(Integer customId) {
        dao.deleteCustom(customId);
    }
    //根据名字搜索客户
    @Override
    public List<Custom> searchCustomByAdminName(String custom_name) {
        dao.searchCustomByAdminName(custom_name);
        return null;
    }
    //修改用户信息
    @Override
    public void modifyCustom(Custom custom) {
        dao.modifyCustom(custom);
    }
    //新增客户
    @Override
    public void addNewCustom(Custom custom) {
        dao.addNewCustom(custom);
    }
}
