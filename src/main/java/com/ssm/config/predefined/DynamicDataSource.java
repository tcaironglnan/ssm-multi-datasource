package com.ssm.config.predefined;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 继承数据源路由的抽象类，该类是DataSource类的子类
 * @author FaceFeel
 * @Created 2018-01-28 12:32
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    /**
     * 切换数据源方法
     * @return 数据源对象
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDbType();
    }
}
