package pers.hong.project.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.*;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: WebMVC配置类
 * @Auther: zwh
 * @Date: 2018/10/18
 */
public class WebMvcConfig implements WebMvcConfigurer {
    public static Logger logger = LoggerFactory.getLogger(WebMvcConfig.class);

    /**
     * 配置异步支持
     *
     * @param configurer
     */
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        configurer.setTaskExecutor(new ThreadPoolTaskExecutor());
        configureAsyncSupport(configurer);
    }

    /**
     * 配置资源控制器
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/statis/**")
                .addResourceLocations("classpath:/static/");
    }

    /**
     * 默认请求处理
     *
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * 跨域访问相关配置
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/test/**") //可以跨域访问的URL路规则
                .allowedOrigins("http://localhost:8080/")  //可以跨域访问的访问者
                .allowedMethods("GET", "POST", "PUT", "DELETE") //可以跨域访问的方法
                .allowedHeaders("")     //可以跨域访问的Headers
        ;
    }

//    /**
//     * 配置异常处理器，会替换系统原本的异常处理器
//     * 可参考SpringMVC的 DefaultHandlerExceptionResolver
//     * @param resolvers
//     */
//    @Override
//    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
//        resolvers.add(new HandlerExceptionResolver() {
//            @Override
//            public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
//                //创建结果集对象
//                Result result = new Result();
//                使用视图对象，根据返回参数做判断，然后进行自定义异常页面跳转
//                if (ex instanceof xxException) {
//                    ModelAndView model = new ModelAndView();
//                    model.setView("", xx);
//                    return model;
//                }else if(ex instanceof yyException){
//                    doOtherThings;
//                }
//
//            }
//
//        });
//    }


    /**
     * 配置读写Request或者Response的BODY的HttpMessageConverter，会替换默认的HttpMessageConverters
     * 这里使用阿里的FastJson作为JSON MessageConverter
     *
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //初始化转换器
        FastJsonHttpMessageConverter fastConvert = new FastJsonHttpMessageConverter();
        //初始化一个转换器配置
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        //将配置设置给转换器并添加到HttpMessageConverter转换器列表中
        fastConvert.setFastJsonConfig(fastJsonConfig);
        //设置编码格式
        fastConvert.setDefaultCharset(Charset.forName("UTF-8"));
        fastConvert.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));
        converters.add(fastConvert);
    }
}