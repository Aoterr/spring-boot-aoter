package com.bee.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * AUTHOR: zorigt
 * DATE  : 18-4-20
 * WEEK  : 星期四
 * TIME  : 15:11
 */
@Configuration
@PropertySource("classpath:datasource.properties")
public class HikariDSConfig {

    private static final String PREFERED_TEST_QUERY = "select 1";


    @Value("${jdbc.driverClass}")
    private String driverClass;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.user}")
    private String user;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.minPoolSize}")
    private String minPoolSize;
    @Value("${jdbc.maxPoolSize}")
    private String maxPoolSize;
    @Value("${jdbc.initialPoolSize}")
    private String initialPoolSize;
    @Value("${jdbc.maxLifeTime}")
    private String maxLifetime;
    @Value("${jdbc.idleTimeout}")
    private String idleTimeout;
    @Value("${jdbc.connectionTimeout}")
    private String connectionTimeout;


    @Bean(destroyMethod = "close")
    public HikariDataSource hikariDataSource() {

        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(driverClass);
        hikariConfig.setJdbcUrl(jdbcUrl);
        hikariConfig.setUsername(user);
        hikariConfig.setPassword(password);

        hikariConfig.setMaximumPoolSize(NumberUtils.toInt(minPoolSize));
        hikariConfig.setMaximumPoolSize(NumberUtils.toInt(maxPoolSize));
        hikariConfig.setMinimumIdle(NumberUtils.toInt(initialPoolSize));
        hikariConfig.setMaxLifetime(NumberUtils.toLong(maxLifetime));
        hikariConfig.setIdleTimeout(NumberUtils.toLong(idleTimeout));
        hikariConfig.setConnectionTimeout(NumberUtils.toLong(connectionTimeout));
        hikariConfig.setConnectionTestQuery(PREFERED_TEST_QUERY);
        hikariConfig.setPoolName("springHikariCP");

        hikariConfig.addDataSourceProperty("dataSource.cachePrepStmts", "true");
        hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSize", "250");
        hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSqlLimit", "2048");
        hikariConfig.addDataSourceProperty("dataSource.useServerPrepStmts", "true");

        return new HikariDataSource(hikariConfig);
    }
}
