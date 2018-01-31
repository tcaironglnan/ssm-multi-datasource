package com.ssm.interceptor;

import com.ssm.config.predefined.DataSource;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import com.ssm.config.predefined.DataSourceContextHolder;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;

/**
 * 数据源切换事务类
 *
 * @author FaceFeel
 * @Created 2018-01-29 10:51
 */
public class DataSourceAspect {

    /**
     * aop前置方法
     *
     * @param joinPoint 连接点
     */
    public void before(JoinPoint joinPoint) throws NoSuchMethodException {

        //如果事务还在执行，并且存储数据源的ThreadLocal中还存在值，则直接返回
        if (TransactionSynchronizationManager.isActualTransactionActive() && DataSourceContextHolder.getDbType() != null) {
            return;
        }
        // 获取方法签名
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        //按照方法名实例化方法
        Method instanceMethod = joinPoint.getTarget().getClass().getMethod(method.getName(),method.getParameterTypes());
        //获取注解
        DataSource annotation = AnnotationUtils.findAnnotation(instanceMethod, DataSource.class);
        //判断获取到的注解是否为空，为空则直接返回
        if (annotation == null){
            return;
        }
        //把方法上的注解字符串值获取到，用于设置数据源
        DataSourceContextHolder.setDbType(annotation.value());
    }

    /**
     * 方法执行完后置空
     * @param joinPoint 连接点
     */
    public void after(JoinPoint joinPoint) {

        //判断事务管理器中的事务是否还在执行，如果还在执行，则直接返回
        if (TransactionSynchronizationManager.isActualTransactionActive()) {
            return;
        }
        //判断线程同步是否还在执行，如果是，则清除该同步
        if (TransactionSynchronizationManager.isSynchronizationActive()) {
            TransactionSynchronizationManager.clearSynchronization();
        }
        //把存储数据源的ThreadLocal值设置为空
        DataSourceContextHolder.setDbType(null);
    }
}
