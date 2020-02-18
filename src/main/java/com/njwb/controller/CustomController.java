package com.njwb.controller;

import com.njwb.entity.Custom;
import com.njwb.entity.Return;
import com.njwb.exception.VoteException;
import com.njwb.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController
public class CustomController {
    @Autowired
    private CustomService  customService;
    //查询所有客户列表
    @RequestMapping("/api/custom/getAllCustom") @CrossOrigin("*")
    public Object getAllCustom() throws VoteException {
        Return<List<Custom>> re = new Return<List<Custom>>(0,customService.getAllCustom());
        return re;
    }
    //删除客户信息
    @RequestMapping(value = "/api/custom/deleteCustom", method = RequestMethod.DELETE) @CrossOrigin("*")
    public Object deleteCustom(@RequestParam("customId") Integer customId) throws VoteException{
        customService.deleteCustom(customId);
        Return<Integer> re = new Return<Integer>(0,0);
        return re;
    }
    //根据名字搜索客户
    @RequestMapping(value ="/api/custom/searchCustomByName", method=RequestMethod.POST) @CrossOrigin("*")
    public Object getAllUser(@RequestBody Map<String,String> params) throws VoteException {
        String custom_name = params.get("key");
        Custom custom = new Custom();
        custom.setCustom_name(custom_name);
        Return<List<Custom>> re = new Return<List<Custom>>(0,customService.searchCustomByAdminName(custom_name));
        return re;
    }
    //修改客户信息
    @PutMapping("/api/custom/modifyCustom") @CrossOrigin("*")
    public Object modifyRoom(@RequestBody Map<String,Custom> params) throws VoteException {
        Custom custom = params.get("modifyInfo");
        customService.modifyCustom(custom);
        Return<Integer> re = new Return<Integer>(0,0);
        return re;
    }
    //添加新客户
    @RequestMapping(value="/api/custom/newCustom",method=RequestMethod.POST) @CrossOrigin("*")
    public Object addNewAdmin(@RequestBody Map<String,Custom> params) throws VoteException, SQLException {
        Custom custom = params.get("newCustom");
        System.out.println(custom);
        customService.addNewCustom(custom);
        Return<Integer> re = new Return<Integer>(0,0);
        return re;

    }
}
