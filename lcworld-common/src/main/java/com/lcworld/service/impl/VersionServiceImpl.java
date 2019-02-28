package com.lcworld.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.lcworld.dao.VersionDao;
import com.lcworld.entity.VersionEntity;
import com.lcworld.service.VersionService;



@Service("versionService")
public class VersionServiceImpl implements VersionService {
	@Autowired
	private VersionDao versionDao;
	
	@Override
	public VersionEntity queryObject(Integer versionId){
		return versionDao.queryObject(versionId);
	}
	
	@Override
	public List<VersionEntity> queryList(Map<String, Object> map){
		return versionDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return versionDao.queryTotal(map);
	}
	
	@Override
	public void save(VersionEntity version){
		versionDao.save(version);
	}
	
	@Override
	public void update(VersionEntity version){
		versionDao.update(version);
	}
	
	@Override
	public void delete(Integer versionId){
		versionDao.delete(versionId);
	}
	
	@Override
	public void deleteBatch(Integer[] versionIds){
		versionDao.deleteBatch(versionIds);
	}

  @Override
  public VersionEntity selectLatest(int type) {
    return versionDao.selectLatest(type);
  }
	
}
