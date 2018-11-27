package cn.com.kiva.springdemo.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

    @Bean
    public ServletRegistrationBean druidSRB(){
        StatViewServlet c =  new StatViewServlet();
        ServletRegistrationBean t = new ServletRegistrationBean(c,"/druid/*");
        t.addInitParameter("loginUsername","admin");
        t.addInitParameter("loginPassword","admin");
        return t;

    }
    @Bean
    public FilterRegistrationBean druidFRB(){
        WebStatFilter c = new WebStatFilter();
        FilterRegistrationBean f = new FilterRegistrationBean(c);
        return f;
    }
}
