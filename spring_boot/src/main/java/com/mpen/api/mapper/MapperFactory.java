/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.mpen.api.mapper;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

/**
 * @author kai
 */
@Configuration
public class MapperFactory {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().addScript(new ClassPathResource("import.sql").getPath()).build();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource());
        return (SqlSessionFactory) sqlSessionFactory.getObject();
    }

    protected <T> MapperFactoryBean<T> getMapper(Class<T> mapperInterface) throws Exception {
        MapperFactoryBean<T> mapperFactoryBean = new MapperFactoryBean<T>();
        mapperFactoryBean.setSqlSessionFactory(sqlSessionFactory());
        mapperFactoryBean.setMapperInterface(mapperInterface);
        return mapperFactoryBean;
    }

    @Bean
    public MapperFactoryBean<CityMapper> cityMapper() throws Exception {
        return getMapper(CityMapper.class);
    }
}
