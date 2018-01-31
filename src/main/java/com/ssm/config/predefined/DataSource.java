package com.ssm.config.predefined;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于动态切换数据源的注解类，目前配置使用的是方法级别
 * 不给默认值
 * @author FaceFeel
 * @Created 2018-01-29 10:37
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface DataSource {
    String value();
}
