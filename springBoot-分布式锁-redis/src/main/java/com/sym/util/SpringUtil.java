package com.sym.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * springBoot获取IOC容器可以实现 ApplicationContextAware 接口
 *
 * @Auther: shenym
 * @Date: 2019-03-26 10:55
 */
@Component
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        SpringUtil.applicationContext = applicationContext;
    }

    public static <T> T getBean(Class<T> t) {
        if (applicationContext != null) {
            return applicationContext.getBean("redisTemplate",t);
        }
        throw new NullPointerException("SpringUtil.applicationContext is null");
    }
}
