package config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: guohezuzi
 * \* Date: 18-2-2
 * \* Time: 下午5:30
 * \* Description:
 * \
 */
@EnableWebMvc
@ComponentScan({"controller", "config", "data"})
@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**配置视图解析*/
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        //tile视图解析
        registry.tiles();

        //jsp视图解析
        registry.jsp("/WEB-INF/views/", ".jsp");
     /*   //jstl视图解析
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(
                org.springframework.web.servlet.view.JstlView.class
        );
        registry.viewResolver(resolver);*/

    }

    /**配置静态资源处理*/
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**配置messageSource根据给定编码获取信息*/
    @Bean
    public MessageSource messageSource() {
        /*//方法一:
        ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
        messageSource.setBasename("messages");//设置属性文件的基本名称,(不加前缀)会在web应用的根路下的属性文件中解析信息
        return messageSource;*/
        //方法二:
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setDefaultEncoding("utf-8");
        //在类路径下的属性文件,在文件系统中配置为:(file:/...)无法使用[存疑!!!(已解决,可正常使用,message匹配错误)]
        messageSource.setBasename("file:/home/guohezuzi/temp/messages");
        messageSource.setCacheSeconds(10);
        return messageSource;
    }

    /**配置apache tiles视图解析*/
    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions("/WEB-INF/layout/tiles.xml",
                "/WEB-INF/views/**/tiles.xml");
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }

    /**配置multipart解析器(处理文件上传)*/
    @Bean
    MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }


/*   @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/css/**").addResourceLocations("/resources/css/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }*/

    /*//servlet 工作环境设置
    @Bean ConfigurableEnvironment configurableEnvironment(){
        ConfigurableEnvironment environment=new StandardEnvironment();
        environment.setActiveProfiles();
        environment.setDefaultProfiles();
        return environment;
    }*/

}
