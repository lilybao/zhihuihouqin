package com.lcworld.test;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.lcworld.entity.TDcfwOrderEntity;

public class SearchQueue extends ConcurrentLinkedQueue<TDcfwOrderEntity> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Object searchElement(Integer id){
		if (id==null||id<=0) {
			return null;
		}
		Iterator<TDcfwOrderEntity> iterator = this.iterator();
		while (iterator.hasNext()) {
			TDcfwOrderEntity order = iterator.next();
			if (id.equals(order.getId())) {
				return order;
			}
		}
		return null;
	}
}
