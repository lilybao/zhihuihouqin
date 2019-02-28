package com.lcworld.service;

import com.lcworld.entity.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * 用户
 * 
 * @author xlf
 * @email xlfbe696@gmail.com
 * @date 2017-07-10 15:41:01
 */
public interface UserService {
	
	UserEntity queryObject(Long userId);
	
	List<UserEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(UserEntity user);
	
	void update(UserEntity user);
	
	void delete(Long userId);
	
	void deleteBatch(Long[] userIds);
}
