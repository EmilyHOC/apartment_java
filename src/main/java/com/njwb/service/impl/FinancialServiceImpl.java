package com.njwb.service.impl;

import com.njwb.dao.DeviceDao;
import com.njwb.dao.FinancialDao;
import com.njwb.entity.Financial;
import com.njwb.entity.Room;
import com.njwb.service.FinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class FinancialServiceImpl implements FinancialService {
    @Autowired
    private FinancialDao dao;
    //获取所有
    @Override
    public List<Financial> getAllFinancialList() {
        List<Financial> financialList = new ArrayList<Financial>();
        financialList = dao.getAllFinancialList();
        return financialList;
    }
}
