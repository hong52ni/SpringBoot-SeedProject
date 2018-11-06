package pers.hong.project.config;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

import static pers.hong.project.common.Constants.*;

/**
 * @Description: Mybatis以及插件配置类
 * @Auther: zwh
 * @Date: 2018/10/18
 */
@Configuration
public class MybatisConfig {
    /**
     * Mybatis的sqlSessionFactoryBean配置
     *
     * @param datasource
     * @return sqlSessionFactoryBean
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean(DataSource datasource) throws Exception {
        Interceptor interceptor = new PageInterceptor();
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(datasource);
        sqlSessionFactoryBean.setTypeAliasesPackage(ENTITY_PACKAGE);

        //PageHelper的代码配置，在application-dev.yml中有相应配置，两种方法选一种
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("pageSizeZero", "true");
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("helperDialect", "mysql");
        pageHelper.setProperties(properties);
        //添加插件，旧版本的pageHelper参数已过期，新版本是使用PageInterceptor对象作为参数
        sqlSessionFactoryBean.setPlugins(new Interceptor[]{interceptor});
        //配置mapper.xml的路径，和xml中mybatis的配置对应
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:mapper/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    /**
     * tk.mybatis的mapper包扫描以及通用mapper配置
     *
     * @return mapperScannerConfigurer
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        mapperScannerConfigurer.setBasePackage(MAPPER_PACKAGE);

        //配置通用Mapper
        Properties properties = new Properties();
        properties.setProperty("mappers", MAPPER_INTERFACE_REFERENCE);
        properties.setProperty("notEmpty", "false");
        properties.setProperty("IDENTITY", "MYSQL");
        mapperScannerConfigurer.setProperties(properties);

        return mapperScannerConfigurer;
    }

}
