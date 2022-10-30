package com.example.kindergarten.config;//package com.zza.government.config;
//
//import com.zza.government.authorization.interceptor.AuthorizationInterceptor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//@Configuration
//public class WebMvcConfig extends WebMvcConfigurerAdapter {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(authorizationInterceptor())
//                .addPathPatterns("/**");  // 拦截所有请求，通过判断是否有 @Login 注解 决定是否需要登录
//        super.addInterceptors(registry);
//    }
//
//    @Bean
//    public AuthorizationInterceptor authorizationInterceptor() {
//        return new AuthorizationInterceptor();
//    }
//}
