package com.myq.springbootjdbc.Config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * jdbc数据源配置类
 */
//@Configuration
//@EnableConfigurationProperties(JdbcProperties.class) //指定加载配置信息类
//@PropertySource("classpath:/jdbc.properties")//加载指定的properties配置文件
public class JdbcConfiguration {
    ////@Autowired
    //private JdbcProperties jdbcProperties;
    //
    //public JdbcConfiguration(JdbcProperties jdbcProperties) {
    //    this.jdbcProperties = jdbcProperties;
    //}

    /**
     * 实例化Druid
     */
    @Bean
    @ConfigurationProperties(prefix = "jdbc")
    public DataSource getDataSource() {
        DruidDataSource source = new DruidDataSource();
        return source;
    }
}
