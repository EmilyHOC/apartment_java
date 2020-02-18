package com.njwb.service.impl;
import com.njwb.dao.DeviceDao;
import com.njwb.entity.Device;
import com.njwb.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    private DeviceDao dao;
    @Override
    public List<Device> getAllDevice() {
        List<Device> deviceList = new ArrayList<Device>();
        deviceList = dao.getAllDevice();
        return deviceList;
    }


}
