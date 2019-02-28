package com.lcworld.dao;

import java.util.List;
import java.util.Map;

import com.lcworld.entity.BaseInfoEntity;

/**
 * 班级,科目,教材,知识点层级关系表
 * 
 * @author xlf
 * @email xlfbe696@gmail.com
 * @date 2017-07-10 16:04:29
 */
public interface BaseInfoDao extends BaseDao<BaseInfoEntity> {

	List<BaseInfoEntity> queryBaseInfoList(Map<String, Object> map);
	
}
