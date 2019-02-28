package com.lcworld.annotation;

import java.lang.annotation.*;

/**
 * 取消token验证注解
 * @author xlf
 * @email xlfbe696@gmail.com
 * @date 2017年4月13日 下午5:34:18
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IgnoreSign {

}
