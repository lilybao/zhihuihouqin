<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4 style="color:orange">——————————————获得验证码测试——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/user/getCaptcha">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"mobile":"13263280712"}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————注册测试——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/user/registerAndLogin">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"mobile":"13263280712","captcha":""}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————添加宝宝信息测试——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/user/addBabbyInfo">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"uid":"2","sex":"1","age":12,"birthday":"2016-08-12","nickname":"尼克"}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————查询用户宝宝——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/user/selectBabbyList">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"userId":"2"}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————获取用户信息——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/user/getUserInfo">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"userId":"2"}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————点击更多分类——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/cateloglevel/more">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"userId":"2"}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————修改用户的分类——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/cateloglevel/updateUserCatelog">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"userId":"2","selectedCList":[1,4,5,6,7]}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————获取用户的消息——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/user/getUserMsg">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"userId":"2"}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————点击分类消息——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/user/getUserMsgByType">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"userId":"2","type":"1"}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————获取消息详情——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/user/getMsgInfo">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"id":"2"}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————删除消息——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/user/deleteMsg">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"id":"2"}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————首页信息——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/index/index">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"userId":"2","lon":116.422464,"lat":40.011988,"regionId":1}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————首页点击任意分类——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/index/clickCatelog">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"userId":"2","lon":116.422464,"lat":40.011988,"regionId":1,"catelogId":1}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————获取指定类型商品的数据——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/index/queryProductByCatelog">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"lon":116.422464,"lat":40.011988,"regionId":1,"catelogId":1}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————获取更多推荐数据——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/index/queryMoreRecommend">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"lon":116.422464,"lat":40.011988,"regionId":1}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————获取更多新到数据——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/index/queryMoreNew">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"lon":116.422464,"lat":40.011988,"regionId":1}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————获取商品详细数据——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/product/queryProductInfo">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"id":1,"userId":1,"lon":116.422464,"lat":40.011988,"regionId":1}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————获取商品的评价——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/product/queryProductCommon">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"id":1,"page":1,"limit":10}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————给用户的商品评价点赞——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/product/praiseProductCommon">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"pcid":1,"isPraise":1,"userId":1}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————点击评论提交——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/product/commentUserCommon">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"pcid":1,"userId":1,"content":"世界那么大你想去看看"}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————添加收藏——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/product/addCollect">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"userId":1,"id":1}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————取消收藏——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/product/deleteCollect">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"userId":1,"id":1}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————查询购物车——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/usercart/queryUserCart">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"userId":1,"id":1,"lon":116.422464,"lat":40.011988}</textarea><br>
		<input type="submit" value="测试">
	</form>
	<!-- 新 -->
	
<h4 style="color:orange">——————————————点击附近的售货机——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/index/queryVendorNearby">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"lon":116.422464,"lat":40.011988,"regionId":1}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————点击柜子的可租按钮——————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/index/clickVendorNormal">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"lon":116.422464,"lat":40.011988,"vendorId":1}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:red">——————————————点击领取代金券(免租时长和代金券)——————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/index/addCouponToUser">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"userId":1,"type":0}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:red">——————————————活动展示——————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/index/activityShow">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz"></textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:red">——————————————折扣商品展示——————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/index/queryDiscountProduct">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"lon":116.422464,"lat":40.011988,"regionId":1}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————加入购物车——————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/product/addMyCart">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"id":1,"vendorId":1,"rentDays":10,"userId":1}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————查询商品所在的柜子列表——————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/product/queryProductVendorList">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"id":1,"lon":116.422464,"lat":40.011988,"regionId":1}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————增减购物项的租用天数——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/usercart/addRentDay">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"cartId":1,"num":1}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————删除购物车项——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/usercart/deleteCartItems">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"cartIdArr":[3,4]}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————点击确认按钮生成订单预览(抢先预定)——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/usercart/generateOrderView">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"userId":1,"lon":116.422464,"lat":40.011988,"productTypeId":1,"vendorId":1}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————预定生成订单——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/order/generateOrder">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"itemArr":[{"productTypeId":1,"ucid":2,"rentDays":20,"vendorId":1},{"productTypeId":2,"ucid":1,"rentDays":20,"vendorId":2}],"userId":1,"cartIdArr":[1,2]}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————查询用户待取货订单——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/order/queryUserUntakeOrders">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"userId":1}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————查询用户已取货订单——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/order/queryUserTokenOrders">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"userId":1}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————查询已完成订单——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/order/queryUserFinishedOrders">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"userId":1}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————扫码取货——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/order/scanQRCodeTake">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"userId":1,"vendorNo":"1234567abcdefg","gridNo":1}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————预约确认取货(关键)同步方法 ——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/order/confirmToGetproduct">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"userId":1,"oid":1,"vendorNo":"1234567abcdefg","gridNo":1}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————关门(硬件调用)——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/hardware/hasClosed">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"term_sn":"1234567abcdefg","data": [{"door_id":"2", "status":0}]}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————发送当前柜子密码——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/order/getGridCode">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"userId":1,"oid":1,"vendorNo":"1234567abcdefg","gridNo":1}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————获取区域内可归还的柜子信息——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/order/getBackVendorList">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"lon":116.422464,"lat":40.011988,"regionId":1}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————预约要归还的柜子——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/order/backAppointment">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"oid":1,"vendorId":1}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————扫码归还信息——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/order/scanForBackInfo">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"userId":1,"oid":1,"vendorNo":"1234567abcdefg","gridNo":1}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————确认归还——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/order/confirmToBack">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"userId":1,"oid":1,"vendorNo":"1234567abcdefg","gridNo":1}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————刷新获取是否关门状态——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/order/isClosed">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"oid":1}</textarea><br>
		<input type="submit" value="测试">
	</form>

<h4 style="color:orange">——————————————最终判断柜子状态——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/order/isClosedFinal">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"oid":1}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:green">——————————————现场扫码获得信息取货或还货——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/order/liveScanForInfo">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"userId":1,"vendorNo":"1234567abcdefg","gridNo":1}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————现场扫码确定取货——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/order/liveScanConfirmToTake">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"productTypeId":1,"userId":1,"vendorId":1,"gridId":1,"rentDays":12}</textarea><br>
		<input type="submit" value="测试">
	</form>
<!-- <h4 style="color:orange">——————————————现场扫码退还信息——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/order/liveScanForBackInfo">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"userId":1,"vendorNo":"1234567abcdefg","gridNo":1}</textarea><br>
		<input type="submit" value="测试">
	</form> -->
<h4 style="color:red">——————————————获取支付商品信息——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/order/payOrderInfoConfirm">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"oid":32}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:red">——————————————点击立即支付获取支付信息——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/order/payInfo">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"oid":1,"userId":1}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:red">——————————————余额支付，钱包支付——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/order/payWithWallet">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"orderName":"小鱼到家-余额支付","userId":1,"totalPay":2.0,"orderNo":"14975057955261","payPassword":"123123"}</textarea><br>
		<input type="text" value="2:密码为空 3:钱包余额不足 4:密码有误">
		<input type="submit" value="测试">
	</form>
<h4 style="color:red">——————————————确定续租——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/order/addRentdays">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"oid":29,"num":1}</textarea><br>
		<input type="text" value="2:密码为空 3:钱包余额不足 4:密码有误">
		<input type="submit" value="测试">
	</form>

<h4 style="color:orange">——————————————搜索商品——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/productSearch/searchProduct">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"keyword":"针织","lon":116.422464,"lat":40.011988}</textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————查询所有品牌——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/productSearch/searchAllBrand">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz"></textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————查询所有分类——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/cateloglevel/queryAll">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz"></textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:orange">——————————————查询能力——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/productSearch/searchAllAbility">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz"></textarea><br>
		<input type="submit" value="测试">
	</form>
<h4 style="color:red">——————————————获取评价标签——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/order/queryCommonTag">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz"></textarea><br>
		<input type="text" value="">
		<input type="submit" value="测试">
	</form>
<h4 style="color:red">——————————————添加商品评论——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/order/addProductCommon" enctype="multipart/form-data">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"userId":1,"ptId":1,"star":2.5,"commonTagArr":[1,2],"common":"真几把男","isAnonymous":1,"oid":29}</textarea><br>
		<input type="text" value="">
		<input type="submit" value="测试">
	</form>
<h4 style="color:red">——————————————校验用户账号是否绑定了手机号——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/mine/verifyLoginAndMobile" enctype="multipart/form-data">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"userId":1}</textarea><br>
		<input type="text" value="1:未绑定手机号">
		<input type="submit" value="测试">
	</form>
<h4 style="color:red">——————————————查询我的优惠券——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/mine/queryCouponByType" enctype="multipart/form-data">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"userId":1,"type":1}</textarea><br>
		<input type="text" value="">
		<input type="submit" value="测试">
	</form>
<h4 style="color:red">——————————————我的搜藏——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/mine/queryUserCollections" enctype="multipart/form-data">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"userId":1}</textarea><br>
		<input type="text" value="">
		<input type="submit" value="测试">
	</form>
<h4 style="color:red">——————————————批量删除搜藏——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/mine/deleteCollectByIds" enctype="multipart/form-data">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"userId":1,"ids":[1,2]}</textarea><br>
		<input type="text" value="">
		<input type="submit" value="测试">
	</form>
<h4 style="color:red">——————————————查询我的信用——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/mine/queryMyCredit" enctype="multipart/form-data">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"userId":1,"page":1,"limit":3}</textarea><br>
		<input type="text" value="">
		<input type="submit" value="测试">
	</form>
<h4 style="color:red">——————————————查询我钱包余额——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/mine/queryUserWallet" enctype="multipart/form-data">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"userId":1}</textarea><br>
		<input type="text" value="">
		<input type="submit" value="测试">
	</form>
<h4 style="color:red">——————————————我的账户明细——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/mine/queryUserWalletDetail" >
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"userId":1,"page":1,"limit":3}</textarea><br>
		<input type="text" value="">
		<input type="submit" value="测试">
	</form>
<h4 style="color:red">——————————————验证手机校验码——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/mine/verifyModile">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"userId":1,"mobile":13263280712,"verifyCode":2123}</textarea><br>
		<input type="text" value="2与账户绑定的手机不一致 3验证码错误">
		<input type="submit" value="测试">
	</form>
<h4 style="color:red">——————————————修改设置支付密码——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/mine/modifyWalletPassword">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"userId":1,"password":"123456"}</textarea><br>
		<input type="text" value="2与账户绑定的手机不一致 3验证码错误">
		<input type="submit" value="测试">
	</form>
<h4 style="color:red">——————————————用户社区首页——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/mine/userCommunityIndex">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"userId":1,"page":1,"limit":3}</textarea><br>
		<input type="text" value="2与账户绑定的手机不一致 3验证码错误">
		<input type="submit" value="测试">
	</form>
<h4 style="color:red">——————————————查询自己的圈子——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/mine/myCommunity">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"userId":1,"page":1,"limit":3}</textarea><br>
		<input type="text" value="2与账户绑定的手机不一致 3验证码错误">
		<input type="submit" value="测试">
	</form>
<h4 style="color:red">——————————————获取所有对用户的评论——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/mine/commentAboutMe">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"cuid":1}</textarea><br>
		<input type="text" value="2与账户绑定的手机不一致 3验证码错误">
		<input type="submit" value="测试">
	</form>
<h4 style="color:red">——————————————我的vip——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/mine/mineVip">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz">{"userId":1}</textarea><br>
		<input type="text" value="">
		<input type="submit" value="测试">
	</form>
<h4 style="color:red">——————————————支付Vip调取信息——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/mine/payVipInfo">
    	<input type="hidden" name="auth" value='{"app_key":"123456","imei":"444012","os":"Iphone os","os_version":"5.0","app_version":"1.0.0","source_id":"Yek_test","ver":"0.9","uid":"-1","crc":"3e64055bf4056d1dc68b85dd4365d649","time_stamp":"20090310113016"}'>
		<textarea title="info" rows="4" cols="150" name="biz"></textarea><br>
		<input type="text" value="">
		<input type="submit" value="测试">
	</form>
</body>
</html>