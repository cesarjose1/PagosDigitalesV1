package com.baz.utils.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {

    @Bean
    public FilterRegistrationBean<RequestCountFilter> loggingFilter() {
        FilterRegistrationBean<RequestCountFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new RequestCountFilter());
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}

