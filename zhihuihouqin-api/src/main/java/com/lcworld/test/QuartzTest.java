package com.lcworld.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.lcworld.entity.TDcfwOrderEntity;
import com.lcworld.utils.DateUtils;

public class QuartzTest {
	public static void main(String[] args) {
		TDcfwOrderEntity order1 = new TDcfwOrderEntity();
		order1.setId(1);
		order1.setExpireTime(DateUtils.getDate(new Date(), Calendar.SECOND, 1));
		TDcfwOrderEntity order2 = new TDcfwOrderEntity();
		order2.setId(2);
		order2.setExpireTime(DateUtils.getDate(new Date(), Calendar.SECOND, 2));
		TDcfwOrderEntity order3 = new TDcfwOrderEntity();
		order3.setId(3);
		order3.setExpireTime(DateUtils.getDate(new Date(), Calendar.SECOND, 3));
		OrderQueueSingleton.getQueue().offer(order1);
		OrderQueueSingleton.getQueue().offer(order2);
		OrderQueueSingleton.getQueue().offer(order3);
		List<TDcfwOrderEntity> orderExpired = orderExpired(new ArrayList<TDcfwOrderEntity>(), new Date());
		if (orderExpired.size()==0) {
			
		}
		System.out.println(orderExpired.size());
	}
	private static List<TDcfwOrderEntity> orderExpired(List<TDcfwOrderEntity> list,Date now){
		TDcfwOrderEntity order = OrderQueueSingleton.getQueue().peek();
		if (order==null) {
			return list;
		}
		if (order.getExpireTime().getTime()<=now.getTime()) {
			TDcfwOrderEntity poll = OrderQueueSingleton.getQueue().poll();
			list.add(poll);
			orderExpired(list, now);
		}
		return list;
	}
}
