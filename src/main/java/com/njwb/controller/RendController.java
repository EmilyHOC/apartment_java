package com.njwb.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.njwb.entity.Rend;
import com.njwb.entity.Return;
import com.njwb.exception.VoteException;
import com.njwb.service.RendService;


@RestController
public class RendController {
	@Autowired
    private RendService  rendService;
    //查询所有合同
    @RequestMapping("/api/rend/getAllRend") @CrossOrigin("*")
    public Object getAllRend() throws VoteException {
        Return<List<Rend>> re = new Return<List<Rend>>(0,rendService.getAllRend());
        return re;
    }
    //搜索合同
    @RequestMapping(value ="/api/rend/searchRendInfo", method=RequestMethod.POST) @CrossOrigin("*")
    public Object searchRendInfo(@RequestBody Map<String,String> params) throws VoteException {
        String rend_Id = params.get("searchVal");
        Return<List<Rend>> re = new Return<List<Rend>>(0,rendService.searchRendInfo(rend_Id));
        return re;
    }
    //退租
    @RequestMapping(value = "/api/rend/deleteRend", method = RequestMethod.DELETE) @CrossOrigin("*")
    public Object deleteRend(@RequestParam("rend_Id") String rend_Id) throws VoteException{
    	rendService.deleteRend(rend_Id);
        Return<Integer> re = new Return<Integer>(0,0);
        return re;
    }
    //修改客户信息
    @PutMapping("/api/rend/conRendInfo") @CrossOrigin("*")
    public Object modifydate(@RequestBody Map<String,String> params) throws VoteException {
        String rend_end = params.get("datetime");
        String rend_Id = params.get("rend_Id");
        rendService.modifyRendEnd(rend_end, rend_Id);
        Return<Integer> re = new Return<Integer>(0,0);
        return re;
    }
//    //添加新客户
//    @RequestMapping(value="/api/custom/newCustom",method=RequestMethod.POST) @CrossOrigin("*")
//    public Object addNewAdmin(@RequestBody Map<String,Custom> params) throws VoteException, SQLException {
//        Custom custom = params.get("newCustom");
//        System.out.println(custom);
//        customService.addNewCustom(custom);
//        Return<Integer> re = new Return<Integer>(0,0);
//        return re;
//
//    }
}
