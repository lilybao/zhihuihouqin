package com.lcworld.consts;

public class RedisConst {
    
    public static final  String REDIS_BASE_URL = "zhhq:";
    public static final String REDIS_USER_BASE_URL = REDIS_BASE_URL+"user:";
    public static final String REDIS_BXWX_BASE_URL = REDIS_BASE_URL+"bxwx:";
    /**
     * 允许图片
     */
    public static String[] UPLOAD_IMG_FILTER = {"GIF","PNG","JPG","JPEG"};
    /**
     * 验证码前缀
     */
    public static final  String USER_CAPTCHA_PRE = REDIS_USER_BASE_URL+"captcha:";
    /**
     * 报修维修订单图片
     */
    public static final  String USER_BXWX_ORDERIMG_PRE = REDIS_BXWX_BASE_URL+"img";
    
    
}
