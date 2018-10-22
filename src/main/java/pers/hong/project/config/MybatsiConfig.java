package pers.hong.project.config;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

import java.util.Properties;

import static pers.hong.project.common.Constants.*;

/**
 * @Description: Mybatis以及插件配置类
 * @Auther: zwh
 * @Date: 2018/10/18
 */
@Configuration
public class MybatsiConfig {
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean(DataSource datasource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(datasource);
        sqlSessionFactoryBean.setTypeAliasesPackage(ENTITY_PACKAGE);

        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("pageSizeZero", "true");


        return sqlSessionFactoryBean.getObject();
    }
}
