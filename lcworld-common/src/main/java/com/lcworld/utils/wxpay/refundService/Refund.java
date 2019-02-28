package com.lcworld.utils.wxpay.refundService;

import java.util.Map;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

import com.lcworld.utils.wxpay.refundUtils.ClientCustomSSL;
import com.lcworld.utils.wxpay.refundUtils.RequestHandler;
import com.lcworld.utils.wxutil.ConstantUtil;
import com.lcworld.utils.wxutil.MD5;
import com.lcworld.utils.wxutil.MD5Util;
import com.lcworld.utils.wxutil.XMLUtil;



public class Refund {
	
	@SuppressWarnings("unchecked")
	public static Map<String,Object> wechatRefund(String outRefundNo,String outTradeNo,String totalFee,String refundFee) {
		//api地址：http://mch.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_4
		String out_refund_no = outRefundNo;// 退款单号
		String out_trade_no = outTradeNo;// 订单号
		String total_fee = totalFee;// 总金额
		String refund_fee = refundFee;// 退款金额
		Random random = new Random();
		String randomStr = MD5.GetMD5String(String.valueOf(random.nextInt(10000)));
		String nonce_str = MD5Util.MD5Encode(randomStr, "utf-8").toLowerCase();// 随机字符串
		String appid = ConstantUtil.APP_ID; //微信公众号apid
		String appsecret = ConstantUtil.APP_SECRET; //微信公众号appsecret
		String mch_id = ConstantUtil.PARTNER;  //微信商户id
		String op_user_id = "1388232102";//就是MCHID
		String partnerkey = ConstantUtil.PARTNER_KEY;//商户平台上的那个KEY
		SortedMap<String, String> packageParams = new TreeMap<String, String>();
		packageParams.put("appid", appid);
		packageParams.put("mch_id", mch_id);
		packageParams.put("nonce_str", nonce_str);
		packageParams.put("out_trade_no", out_trade_no);
		packageParams.put("out_refund_no", out_refund_no);
		packageParams.put("total_fee", total_fee);
		packageParams.put("refund_fee", refund_fee);
		packageParams.put("op_user_id", op_user_id);

		RequestHandler reqHandler = new RequestHandler(
				null, null);
		reqHandler.init(appid, appsecret, partnerkey);

		String sign = reqHandler.createSign(packageParams);
		String xml = "<xml>" + "<appid>" + appid + "</appid>" + "<mch_id>"
				+ mch_id + "</mch_id>" + "<nonce_str>" + nonce_str
				+ "</nonce_str>" + "<sign><![CDATA[" + sign + "]]></sign>"
				+ "<out_trade_no>" + out_trade_no + "</out_trade_no>"
				+ "<out_refund_no>" + out_refund_no + "</out_refund_no>"
				+ "<total_fee>" + total_fee + "</total_fee>"
				+ "<refund_fee>" + refund_fee + "</refund_fee>"
				+ "<op_user_id>" + op_user_id + "</op_user_id>" + "</xml>";
		String createOrderURL = "https://api.mch.weixin.qq.com/secapi/pay/refund";
		try {
			String s= ClientCustomSSL.doRefund(createOrderURL, xml);
			System.out.println("微信退款==="+s);
			return XMLUtil.doXMLParse(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		Refund refund=new Refund();
		refund.wechatRefund("4006132001201702150036918520", "201702151622298967284509966", "100", "100");
	}
}
