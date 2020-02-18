package com.njwb.controller;

import com.njwb.entity.Device;
import com.njwb.entity.Return;
import com.njwb.exception.VoteException;
import com.njwb.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeviceController {
    @Autowired
    private DeviceService deviceService;
    //查询所有设备租赁信息
    @RequestMapping("/api/custom/getAllCustom") @CrossOrigin("*")
    public Object getAllDevice() throws VoteException {
        Return<List<Device>> re = new Return<List<Device>>(0,deviceService.getAllDevice());
        return re;
    }
}
