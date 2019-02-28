package com.lcworld.service;

import com.lcworld.entity.BaseInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 班级,科目,教材,知识点层级关系表
 * 
 * @author xlf
 * @email xlfbe696@gmail.com
 * @date 2017-07-10 16:04:29
 */
public interface BaseInfoService {
	
	BaseInfoEntity queryObject(Long id);
	
	List<BaseInfoEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(BaseInfoEntity baseInfo);
	
	void update(BaseInfoEntity baseInfo);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

	/**
	 * 查询年级列表
	 * @return
	 */
	List<BaseInfoEntity> queryBaseInfoList(Map<String, Object> map);
}
