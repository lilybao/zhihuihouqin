package com.lcworld.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lcworld.dao.TPraiseDao;
import com.lcworld.dao.TYytcMealDao;
import com.lcworld.entity.TFavorEntity;
import com.lcworld.entity.TPraiseEntity;
import com.lcworld.entity.TYytcMealEntity;
import com.lcworld.service.TPraiseService;
import com.lcworld.utils.APPConstant;
import com.lcworld.utils.util.ValidateUtil;



@Service("tPraiseService")
public class TPraiseServiceImpl implements TPraiseService {
	@Autowired
	private TPraiseDao tPraiseDao;
	@Autowired
	private TYytcMealDao tYytcMealDao;
	@Override
	public TPraiseEntity queryObject(Integer upId){
		return tPraiseDao.queryObject(upId);
	}
	
	@Override
	public List<TPraiseEntity> queryList(Map<String, Object> map){
		return tPraiseDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return tPraiseDao.queryTotal(map);
	}
	
	@Override
	public void save(TPraiseEntity tPraise){
		tPraiseDao.save(tPraise);
	}
	
	@Override
	public void update(TPraiseEntity tPraise){
		tPraiseDao.update(tPraise);
	}
	
	@Override
	public void delete(Integer upId){
		tPraiseDao.delete(upId);
	}
	
	@Override
	public void deleteBatch(Integer[] upIds){
		tPraiseDao.deleteBatch(upIds);
	}
	@Override
	public void saveOrUpdate(TPraiseEntity praise) {
		//条件查询数据库中是否存在
		HashMap<String,Object> paramsMap = new HashMap<>();
		paramsMap.put("uid", praise.getUid());
		paramsMap.put("type", praise.getUpTargetType());
		paramsMap.put("entityid", praise.getEntityid());
		List<TPraiseEntity> praiseList = tPraiseDao.queryList(paramsMap);
		int addOrDel = -1;
		if (ValidateUtil.isValid(praiseList)) {
			//对象存在更新
			TPraiseEntity praiseEntity = praiseList.get(0);
			addOrDel = Math.abs(praiseEntity.getUpStatus()-1);
			praiseEntity.setUpStatus(addOrDel);
			tPraiseDao.update(praiseEntity);
		}else{
			//对象不存在
			addOrDel = APPConstant.TYPE_STATUS_HAS;
			praise.setUpStatus(addOrDel);
			tPraiseDao.save(praise);
		}
		//改变对应对象中的点赞数量
		changePraiseNumOf(praise.getUpTargetType(),praise.getEntityid(),addOrDel);
	}

	private void changePraiseNumOf(Integer favortype, Integer entityid, int addOrDel) {
		int amount = addOrDel == 0?-1:1;
		switch (favortype.intValue()) {
		case 10:
			TYytcMealEntity meal = tYytcMealDao.queryObject(entityid);
			if (meal!=null) {
				meal.setMPraiseNum(meal.getMPraiseNum()+amount);
				tYytcMealDao.update(meal);
			}
			break;

		default:
			break;
		}
	}
}
