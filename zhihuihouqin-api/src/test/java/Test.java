import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.client.utils.URLEncodedUtils;

import com.alibaba.fastjson.JSONObject;
import com.lcworld.utils.wxutil.MD5Util;

public class Test {
    public static void main(String[] args) throws Exception {
       System.out.println(createToken());
    }
    
    public static String createToken() throws Exception{
        String token ="f6d41774-de9b-4a8d-9269-216a60241bd0";
        String timestamp = "14323";
        JSONObject obj = new JSONObject();
        obj.put("userName", "13269770032");
        obj.put("from", 0);
        obj.put("captcha", 452001);
        obj.put("password", 123456);
        String biz = obj.toJSONString();
        System.out.println(biz);
        String secretKey ="zxcadsadwa@2321$";
        String encodebiz = URLEncoder.encode(biz, "UTF-8") + timestamp + secretKey;
        System.out.println(encodebiz);
        String sign = DigestUtils.md5Hex(encodebiz);
        return sign;
    }
    
}
