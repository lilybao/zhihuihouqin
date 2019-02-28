package com.lcworld.utils;

//接口类型：互亿无线触发短信接口，支持发送验证码短信、订单通知短信等。
// 账户注册：请通过该地址开通账户http://sms.ihuyi.com/register.html
// 注意事项：
//（1）调试期间，请用默认的模板进行测试，默认模板详见接口文档；
//（2）请使用 用户名(例如：cf_demo123)及 APIkey来调用接口，APIkey在会员中心可以获取；
//（3）该代码仅供接入互亿无线短信接口参考使用，客户可根据实际需要自行编写；

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import org.dom4j.Document;   
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;   
import org.dom4j.Element;   


public class Sendsms {
	
	private static String Url = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";
	
	private static String VoiceUrl = "http://api.voice.ihuyi.com/webservice/voice.php?method=Submit";
	
	public static String sendMsg(String mobile, String content){
		
		HttpClient client = new HttpClient(); 
		PostMethod method = new PostMethod(Url);

		client.getParams().setContentCharset("GBK");
		method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=GBK");

//		int mobile_code = (int)((Math.random()*9+1)*100000);
//	    content = new String("您的验证码是：" + mobile_code + "。请不要把验证码泄露给其他人。");
	    
		NameValuePair[] data = {//提交短信
			    new NameValuePair("account", "C89989456"), 
			    new NameValuePair("password", "c7d2810bd19eafd67fc47b05cd1e7d47"), //查看密码请登录用户中心->验证码、通知短信->帐户及签名设置->APIKEY
			    new NameValuePair("mobile", mobile), 
			    new NameValuePair("content", content),
		};
		method.setRequestBody(data);

		try {
			client.executeMethod(method);
			String SubmitResult =method.getResponseBodyAsString();
			Document doc = DocumentHelper.parseText(SubmitResult);
			Element root = doc.getRootElement();

			String code = root.elementText("code");
			String msg = root.elementText("msg");
			String smsid = root.elementText("smsid");

			System.out.println(code);
			System.out.println(msg);
			System.out.println(smsid);

			 if("2".equals(code)){
				System.out.println("短信提交成功");
			}
			return code;
		} catch (HttpException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (DocumentException e) {
			
			e.printStackTrace();
		}	
		return null;
	}
	
	//接口类型：互亿无线语音验证码接口。
	//账户注册：请通过该地址开通账户http://sms.ihuyi.com/register.html
	//注意事项：
	//（1）调试期间，请仔细阅读接口文档；
	//（2）请使用 用户名(例如：cf_demo123)及 APIkey来调用接口，APIkey在会员中心可以获取；
	//（3）该代码仅供接入互亿无线短信接口参考使用，客户可根据实际需要自行编写；
    public static String voiceMsg(String mobile, String content) {
         
        HttpClient client = new HttpClient();
        PostMethod method = new PostMethod(VoiceUrl);
 
        //client.getParams().setContentCharset("GBK");
        client.getParams().setContentCharset("UTF-8");
        method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=UTF-8");
 
        NameValuePair[] data = {//提交短信
        		new NameValuePair("account", "C89989456"), 
 			    new NameValuePair("password", "c7d2810bd19eafd67fc47b05cd1e7d47"), //查看密码请登录用户中心->验证码、通知短信->帐户及签名设置->APIKEY
 			    new NameValuePair("mobile", mobile), 
 			    new NameValuePair("content", content),
        };
 
        method.setRequestBody(data);
 
        try {
            client.executeMethod(method);
             
            String SubmitResult = method.getResponseBodyAsString();
 
            //System.out.println(SubmitResult);
 
            Document doc = DocumentHelper.parseText(SubmitResult);
            Element root = doc.getRootElement();
 
            String code = root.elementText("code");
            String msg = root.elementText("msg");
            String voiceid = root.elementText("voiceid");
 
            System.out.println(code);
            System.out.println(msg);
            System.out.println(voiceid);
 
             if("2".equals(code)){
                System.out.println("短信提交成功");
            }
            return code;
        } catch (HttpException e) {
            
            e.printStackTrace();
        } catch (IOException e) {
           
            e.printStackTrace();
        } catch (DocumentException e) {
            
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 发送验证码
     * @param mobile
     * @param code
     * @return String
     * @throws
     */
    public static String sendVerificationCodeMsg(String mobile, String code){
    	String content = "您的验证码是："+code+"。请不要把验证码泄露给其他人。如非本人操作，可不用理会！";
    	String sendMsg = sendMsg(mobile, content);
    	return sendMsg;
    }
    /**
     * 发送开柜密码
     * @param mobile
     * @param code
     * @return String
     * @throws
     */
    public static String sendCodeMsg(String mobile, String code){
    	String content = "您的手动开柜密码是："+code+"。温馨提示如若还未打开请拨打人工服务 ";
    	String sendMsg = sendMsg(mobile, content);
    	return sendMsg;
    }
    /**
     * 发送关门提示(给用户)
     * @param mobile
     * @param code
     * @return String
     * @throws
     */
    public static String sendCloseMsgToUser(String mobile, String address,String vendorNo,String gridNo){
    	String content = "您的柜子未关，地址："+address+"柜子："+vendorNo+"格子："+gridNo;
    	String sendMsg = sendMsg(mobile, content);
    	return sendMsg;
    }
    /**
     * 发送关门提示(给运维)
     * @param mobile
     * @param address
     * @param vendorNo
     * @param gridNo
     * @return String
     * @throws
     */
    public static String sendCloseMsgToAdmin(String mobile, String address,String vendorNo,String gridNo){
    	String content = "您的柜子未关，地址："+address+"柜子："+vendorNo+"格子："+gridNo;
    	String sendMsg = sendMsg(mobile, content);
    	return sendMsg;
    }
	public static void main(String [] args) {
		
		Sendsms.sendMsg("13263280712", "您的验证码是：1234。请不要把验证码泄露给其他人。如非本人操作，可不用理会！");
		
	}
	
}