package com.lcworld.service;

import com.lcworld.entity.TPraiseEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author xlf
 * @email xlfbe696@gmail.com
 * @date 2017-08-11 10:53:19
 */
public interface TPraiseService {
	
	TPraiseEntity queryObject(Integer upId);
	
	List<TPraiseEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TPraiseEntity tPraise);
	
	void update(TPraiseEntity tPraise);
	
	void delete(Integer upId);
	
	void deleteBatch(Integer[] upIds);

	void saveOrUpdate(TPraiseEntity praise);
}
