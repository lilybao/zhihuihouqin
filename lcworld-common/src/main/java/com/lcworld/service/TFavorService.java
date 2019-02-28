package com.lcworld.service;

import com.lcworld.entity.TFavorEntity;

import java.util.List;
import java.util.Map;

/**
 * 收藏
 * 
 * @author xlf
 * @email xlfbe696@gmail.com
 * @date 2017-08-11 10:53:19
 */
public interface TFavorService {
	
	TFavorEntity queryObject(Integer id);
	
	List<TFavorEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TFavorEntity tFavor);
	
	void update(TFavorEntity tFavor);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

	void saveOrUpdate(TFavorEntity favor);
}
