<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4 style="color:orange">——————————————微信支付生成预支付订单——————————————————————</h4>
  <h4>测试：</h4>
    <form method="post" action="/zhihuihouqin-api/pay/weixinpay">
		<textarea title="info" rows="4" cols="150" name="biz">{"orderNo":"14981125889821","openid":"oLoqst_qNjhTRMqfMn9nhnYBPgSE"}</textarea><br>
		<input type="submit" value="测试">
	</form>
</body>
</html>