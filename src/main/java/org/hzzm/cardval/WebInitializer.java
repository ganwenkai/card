package org.hzzm.cardval;

import org.apache.log4j.Logger;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by zealotpz on 2016/10/26.
 */
public class WebInitializer implements WebApplicationInitializer {
private Logger logger = Logger.getLogger(WebInitializer.class);
    /**
     * Spring容器启动时
     * 	加载WebConfiguration配置文件
     * 	设置UTF-8字符编码
     * 	设置DispatcherServlet
     */
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        logger.info("Load Configuration file:"+WebConfiguration.class.getName());
        ctx.register(WebConfiguration.class);
        ctx.setServletContext(servletContext);

        javax.servlet.FilterRegistration.Dynamic filter = servletContext.addFilter("CharacterEncodingFilter", new CharacterEncodingFilter("UTF-8"));
        filter.addMappingForUrlPatterns(null, true, "/*");

        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
        servlet.addMapping("/*");
        servlet.setLoadOnStartup(1);

    }
}
