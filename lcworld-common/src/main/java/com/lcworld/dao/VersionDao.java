package com.lcworld.dao;

import com.lcworld.entity.VersionEntity;

/**
 * 版本表
 * 
 * @author xlf
 * @email xlfbe696@gmail.com
 * @date 2017-04-27 16:00:35
 */
public interface VersionDao extends BaseDao<VersionEntity> {

  /**
   * 查询最新的版本号
   * @param type
   * @return
   */
  VersionEntity selectLatest(int type);
	
}
