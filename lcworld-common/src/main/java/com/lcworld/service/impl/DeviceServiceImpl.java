package com.lcworld.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.lcworld.dao.DeviceDao;
import com.lcworld.entity.DeviceEntity;
import com.lcworld.service.DeviceService;



@Service("deviceService")
public class DeviceServiceImpl implements DeviceService {
	@Autowired
	private DeviceDao deviceDao;
	
	@Override
	public DeviceEntity queryObject(Long deviceId){
		return deviceDao.queryObject(deviceId);
	}
	
	@Override
	public List<DeviceEntity> queryList(Map<String, Object> map){
		return deviceDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return deviceDao.queryTotal(map);
	}
	
	@Override
	public void save(DeviceEntity device){
		deviceDao.save(device);
	}
	
	@Override
	public void update(DeviceEntity device){
		deviceDao.update(device);
	}
	
	@Override
	public void delete(Long deviceId){
		deviceDao.delete(deviceId);
	}
	
	@Override
	public void deleteBatch(Long[] deviceIds){
		deviceDao.deleteBatch(deviceIds);
	}
	
}
