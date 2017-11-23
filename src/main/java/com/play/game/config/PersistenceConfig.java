package com.play.game.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;

@Configuration
@PropertySource(value = {"classpath:persistence.properties"})
@EnableTransactionManagement(proxyTargetClass = true)
@MapperScan(basePackages = {"com.play.game.repository.mysql"})
public class PersistenceConfig {

    @Resource
    private Environment env;

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean(destroyMethod = "close", initMethod = "init")
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setDriverClassName(env.getProperty("druid.driverClassName").trim());
        dataSource.setInitialSize(Integer.parseInt(env.getProperty("druid.initialSize").trim()));
        dataSource.setMinIdle(Integer.parseInt(env.getProperty("druid.minIdle").trim()));
        dataSource.setMaxActive(Integer.parseInt(env.getProperty("druid.maxActive").trim()));
        dataSource.setMaxWait(Long.parseLong(env.getProperty("druid.maxWait").trim()));
        dataSource.setTimeBetweenEvictionRunsMillis(Long.parseLong(env.getProperty("druid.timeBetweenEvictionRunsMillis").trim()));
        dataSource.setMinEvictableIdleTimeMillis(Long.parseLong(env.getProperty("druid.minEvictableIdleTimeMillis").trim()));
        dataSource.setValidationQuery(env.getProperty("druid.validationQuery").trim());
        dataSource.setTestWhileIdle(Boolean.valueOf(env.getProperty("druid.testWhileIdle").trim()));
        dataSource.setTestOnBorrow(Boolean.valueOf(env.getProperty("druid.testOnBorrow").trim()));
        dataSource.setTestOnReturn(Boolean.valueOf((env.getProperty("druid.testOnReturn").trim())));
        dataSource.setPoolPreparedStatements(Boolean.valueOf(env.getProperty("druid.poolPreparedStatements").trim()));
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(Integer.parseInt(env.getProperty("druid.maxPoolPreparedStatementPerConnectionSize").trim()));
        dataSource.setUrl(env.getProperty("druid.url").trim());
        dataSource.setUsername(env.getProperty("druid.user").trim());
        dataSource.setPassword(env.getProperty("druid.password").trim());

//		try {
//			dataSource.setFilters(env.getProperty("druid.filters"));
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

        return dataSource;
    }

    @Bean
    public SqlSessionFactory basicSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mybatis/mapper/*Mapper.xml"));
        return sqlSessionFactoryBean.getObject();
    }

//    @Bean
//    public MongoDbFactory mongoDbFactory() throws Exception {
//
//        final MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
//        builder.minConnectionsPerHost(Integer.valueOf(env.getProperty("mongo.minConnectionsPerHost")));
//        builder.connectionsPerHost(Integer.valueOf(env.getProperty("mongo.maxConnectionsPerHost")));
//        builder.socketKeepAlive(true);
//        builder.connectTimeout(10 * 1000);
//        builder.socketTimeout(10 * 1000);
//        builder.threadsAllowedToBlockForConnectionMultiplier(50);
//        final MongoClientURI mongoClientURI = new MongoClientURI(env.getProperty("mongo.uri"), builder);
//
//        return new SimpleMongoDbFactory(mongoClientURI);
//    }
//
//    @Bean
//    public MongoTemplate mongoTemplate() throws Exception {
//        MappingMongoConverter converter = new MappingMongoConverter(new DefaultDbRefResolver(mongoDbFactory()), new MongoMappingContext());
//        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
//        // converter.setCustomConversions(customConversions());
//        converter.afterPropertiesSet();
//
//        return new MongoTemplate(mongoDbFactory(), converter);
//    }

}
