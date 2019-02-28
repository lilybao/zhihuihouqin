package com.lcworld.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lcworld.dao.TFavorDao;
import com.lcworld.dao.TYytcMealDao;
import com.lcworld.entity.TFavorEntity;
import com.lcworld.entity.TYytcMealEntity;
import com.lcworld.service.TFavorService;
import com.lcworld.utils.APPConstant;
import com.lcworld.utils.util.ValidateUtil;



@Service("tFavorService")
public class TFavorServiceImpl implements TFavorService {
	@Autowired
	private TFavorDao tFavorDao;
	@Autowired
	private TYytcMealDao tYytcMealDao;
	
	@Override
	public TFavorEntity queryObject(Integer id){
		return tFavorDao.queryObject(id);
	}
	
	@Override
	public List<TFavorEntity> queryList(Map<String, Object> map){
		return tFavorDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return tFavorDao.queryTotal(map);
	}
	
	@Override
	public void save(TFavorEntity tFavor){
		tFavorDao.save(tFavor);
	}
	
	@Override
	public void update(TFavorEntity tFavor){
		tFavorDao.update(tFavor);
	}
	
	@Override
	public void delete(Integer id){
		tFavorDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		tFavorDao.deleteBatch(ids);
	}

	@Override
	public void saveOrUpdate(TFavorEntity favor) {
		//条件查询数据库中是否存在
		HashMap<String,Object> paramsMap = new HashMap<>();
		paramsMap.put("uid", favor.getUid());
		paramsMap.put("type", favor.getFavortype());
		paramsMap.put("entityid", favor.getEntityid());
		List<TFavorEntity> favorList = tFavorDao.queryList(paramsMap);
		int addOrDel = -1;
		if (ValidateUtil.isValid(favorList)) {
			//对象存在更新
			TFavorEntity favorEntity = favorList.get(0);
			addOrDel = Math.abs(favorEntity.getStatus()-1);
			favorEntity.setStatus(addOrDel);
			tFavorDao.update(favorEntity);
		}else{
			//对象不存在
			addOrDel = APPConstant.TYPE_STATUS_HAS;
			favor.setStatus(addOrDel);
			favor.setCreatetime(new Date());
			tFavorDao.save(favor);
		}
		//改变对应对象中的点赞数量
		changeFavorNumOf(favor.getFavortype(),favor.getEntityid(),addOrDel);
	}

	private void changeFavorNumOf(Integer favortype, Integer entityid, int addOrDel) {
		int amount = addOrDel == 0?-1:1;
		switch (favortype.intValue()) {
		case 10:
			TYytcMealEntity meal = tYytcMealDao.queryObject(entityid);
			if (meal!=null) {
				meal.setMFavorNum(meal.getMFavorNum()+amount);
				tYytcMealDao.update(meal);
			}
			break;

		default:
			break;
		}
	}
	
}
