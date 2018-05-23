package config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: guohezuzi
 * \* Date: 18-2-2
 * \* Time: 下午9:26
 * \* Description:数据库访问配置
 * \
 */
@Configuration
@MapperScan({"data/mapper"})
public class DateConfig{
    //数据源
    @Bean
    public DataSource dateSource(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/JavaCMS?serverTimezone=Hongkong&useSSL=false");
        dataSource.setUsername("javacms");
        dataSource.setPassword("123456");
        return dataSource;
    }

    //事务管理
    @Bean(name = "transactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

    //mybatis sqlSessionFactory配置
    @Bean
    public SqlSessionFactoryBean sessionFactoryBean(DataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean= new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        //sqlSessionFactoryBean.setMapperLocations(new Resource[]{new ClassPathResource("data.mapper/SongMapper.xml")});
        return sqlSessionFactoryBean;
    }

    //mybatis sqlSession配置 可以替代sqlSessionFactory简化代码
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
       return new SqlSessionTemplate(sqlSessionFactory);
    }

    //mybatis MapperFactory注入映射器配置 可以在dao层直接使用 而不需要配置sqlSession
    /*@Bean
    public MapperFactoryBean mapperFactoryBean(SqlSessionTemplate sqlSessionTemplate){
        MapperFactoryBean mapperFactoryBean=new MapperFactoryBean();
        mapperFactoryBean.setSqlSessionTemplate(sqlSessionTemplate);
        return mapperFactoryBean;
    }*/

    //mongodb连接数据库Bean
    /*@Bean
    MongoClientFactoryBean mongoClientFactoryBean(){
        MongoClientFactoryBean mongoClientFactoryBean=new MongoClientFactoryBean();
        mongoClientFactoryBean.setHost("127.0.0.1");
        mongoClientFactoryBean.setPort(27017);
        MongoClientOptions options=MongoClientOptions.builder().build();
        mongoClientFactoryBean.setMongoClientOptions(options);
        return mongoClientFactoryBean;
    }

    @Bean
    public MongoOperations mongoTemplate(MongoClient mongo){
        return new MongoTemplate(mongo,"test");
    }*/

   /* //redis连接数据库配置
    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){
        RedisSentinelConfiguration sentinelConfiguration=new RedisSentinelConfiguration().
                sentinel("127.0.0.1",12704);
        return new JedisConnectionFactory(sentinelConfiguration);
    }
    @Bean
    public RedisTemplate<String,Object> redisTemplate(JedisConnectionFactory jedisConnectionFactory){
        RedisTemplate<String,Object> redisTemplate=new  RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }*/

    //spring自带JDBC操作
    @Bean
    public JdbcOperations jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
