package com.lcworld.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.lcworld.dao.BaseInfoDao;
import com.lcworld.entity.BaseInfoEntity;
import com.lcworld.service.BaseInfoService;



@Service("baseInfoService")
public class BaseInfoServiceImpl implements BaseInfoService {
	@Autowired
	private BaseInfoDao baseInfoDao;
	
	@Override
	public BaseInfoEntity queryObject(Long id){
		return baseInfoDao.queryObject(id);
	}
	
	@Override
	public List<BaseInfoEntity> queryList(Map<String, Object> map){
		return baseInfoDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return baseInfoDao.queryTotal(map);
	}
	
	@Override
	public void save(BaseInfoEntity baseInfo){
		baseInfoDao.save(baseInfo);
	}
	
	@Override
	public void update(BaseInfoEntity baseInfo){
		baseInfoDao.update(baseInfo);
	}
	
	@Override
	public void delete(Long id){
		baseInfoDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		baseInfoDao.deleteBatch(ids);
	}

	@Override
	public List<BaseInfoEntity> queryBaseInfoList(Map<String, Object> map) {
		return baseInfoDao.queryBaseInfoList(map);
	}
	
}
