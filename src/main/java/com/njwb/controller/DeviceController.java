package com.njwb.controller;

import com.njwb.entity.Device;
import com.njwb.entity.Return;
import com.njwb.exception.VoteException;
import com.njwb.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController
public class DeviceController {
    @Autowired
    private DeviceService deviceService;
    //查询所有设备租赁信息
    @RequestMapping("/api/device/getAllDevice") @CrossOrigin("*")
    public Object getAllDevice() throws VoteException {
        Return<List<Device>> re = new Return<List<Device>>(0,deviceService.getAllDevice());
        return re;
    }
    //新增设备租赁订单
    @RequestMapping(value="/api/device/newDevice",method=RequestMethod.POST) @CrossOrigin("*")
    public Object addNewCustom(@RequestBody Map<String,Device> params) throws VoteException, SQLException {
        Device device = params.get("newdevice");
        System.out.println(device);
        deviceService.addNewDevice(device);
        Return<Integer> re = new Return<Integer>(0,0);
        return re;
    }
    //搜索订单
  	@RequestMapping(value="/api/device/searchDevice",method=RequestMethod.POST) @CrossOrigin("*") 
  	public Object searchUser(@RequestBody Map<String,String> params) throws VoteException, SQLException {
  		String device_Id = (String) params.get("deviceOrder");
  		Return<List<Device>> re = new Return<List<Device>>(0,deviceService.searchOrderById(device_Id));
  		return re;
  	}
  	//改变设备状态
    //修改客户信息
    @PutMapping("/api/device/changeDeviceStatus") @CrossOrigin("*")
    public Object changeDeviceStatus(@RequestBody Map<String,String> params) throws VoteException {
        String deviceId = params.get("deviceId");
        String device_status = params.get("status");
        String device_return = params.get("returntime");
        System.out.println(deviceId+"."+device_status);
        deviceService.changeDeviceStatus(deviceId,device_status,device_return);
        Return<Integer> re = new Return<Integer>(0,0);
        return re;
    }
  	
}
