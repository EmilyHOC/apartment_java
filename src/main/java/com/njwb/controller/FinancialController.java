package com.njwb.controller;

import com.njwb.entity.Financial;
import com.njwb.entity.Return;
import com.njwb.exception.VoteException;
import com.njwb.service.FinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FinancialController {
    @Autowired
    private FinancialService financialService;
    //查询所有结算信息
    @RequestMapping("/api/financial/getAllFinancialList") @CrossOrigin("*")
    public Object getAllFinancialList() throws VoteException {
        Return<List<Financial>> re = new Return<List<Financial>>(0,financialService.getAllFinancialList());
        return re;
    }
}
