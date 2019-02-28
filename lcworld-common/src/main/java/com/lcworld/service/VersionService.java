package com.lcworld.service;

import com.lcworld.entity.VersionEntity;

import java.util.List;
import java.util.Map;

/**
 * 版本表
 * 
 * @author xlf
 * @email xlfbe696@gmail.com
 * @date 2017-04-27 16:00:35
 */
public interface VersionService {
	
	VersionEntity queryObject(Integer versionId);
	
	List<VersionEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(VersionEntity version);
	
	void update(VersionEntity version);
	
	void delete(Integer versionId);
	
	void deleteBatch(Integer[] versionIds);

	/**
	 * 查询最新的版本号
	 * @param type
	 * @return
	 */
	VersionEntity selectLatest(int type);
}
