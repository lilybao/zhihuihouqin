package com.lcworld.utils;

import java.math.BigDecimal;

/**
 * api常量
 * @ClassName: APIConstant
 * @Company: http://www.lcworld.cn/
 * @Description: 
 * @author leojr 
 * @date 2017年6月6日 下午3:46:52
 */
public class APPConstant {
	//系统对应类型：1: 公告，2：办公，3：作品，4：图书，5：医生，6：活动，
	//7：发型师 8:健康资讯 9： 专家 10营养套餐11干洗12订餐13：报修14工作餐
	public static final Integer TYPE_XXGG = 1;
	public static final Integer TYPE_YYTC = 10;
	public static final Integer TYPE_GXDFW = 11;
	public static final Integer TYPE_DCFW = 12;
	public static final Integer TYPE_BXFW = 13;
	public static final Integer TYPE_DCFW_GZC = 14;
	//状态1有0无
	public static final Integer TYPE_STATUS_HAS = 1;
	public static final Integer TYPE_STATUS_NO = 0;
	//营养套餐
	public static final Integer YYTC_MTYPE_BREAKFAST = 1;
	public static final Integer YYTC_MTYPE_LUNCH = 2;
	public static final Integer YYTC_MTYPE_DINNER = 3;
	//订单状态
	public static final Integer TYPE_ORDER_STATUS_ORDERED = 1;
	public static final Integer TYPE_ORDER_STATUS_SERVING = 2;
	public static final Integer TYPE_ORDER_STATUS_FINISHED = 3;
	public static final Integer TYPE_ORDER_STATUS_EVALUATED = 4;
	public static final Integer TYPE_ORDER_STATUS_CANCEL = 5;
	//干洗订单Log状态
	public static final Integer TYPE_GXDFW_LOG_STATUS_ORDERED = 1;
	public static final Integer TYPE_GXDFW_LOG_STATUS_WAITSEND = 2;
	public static final Integer TYPE_GXDFW_LOG_STATUS_WASHING = 3;
	public static final Integer TYPE_GXDFW_LOG_STATUS_FINISH = 4;
	public static final Integer TYPE_GXDFW_LOG_STATUS_TOKEN = 5;
	public static final Integer TYPE_GXDFW_LOG_STATUS_PAYED = 6;
	public static final Integer TYPE_GXDFW_LOG_STATUS_EVALUATED = 7;
	
	//支付状态
	public static final Integer TYPE_ORDER_PAY_STATUS_PAYED = 1;
	public static final Integer TYPE_ORDER_PAY_STATUS_UNPAY = 0;
	//15分钟过期时间
	public static final int TYPE_DCFW_EXPIRETIME = 15;
	public static final BigDecimal Type_DCFW_GZC_PRICE = new BigDecimal(30);
	
}
