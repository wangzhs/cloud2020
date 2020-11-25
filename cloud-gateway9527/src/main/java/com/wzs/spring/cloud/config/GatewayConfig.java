package com.wzs.spring.cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangzhs
 * @since 25/11/2020
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                // 同等于配置文件
                .route(r -> r.uri("http://localhost:8001").predicate(p -> p.getRequest().getPath().subPath(0).toString().startsWith("/payment/")))
//                .route(r -> r.uri("http://news.baidu.com/guoji"))
                .build();
    }

}
