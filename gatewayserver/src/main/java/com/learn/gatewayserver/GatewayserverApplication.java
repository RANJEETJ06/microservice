package com.learn.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayserverApplication.class, args);
    }

    @Bean
    public RouteLocator learnRouteRouteConfig(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes()
                .route(
                        p->p
                                .path("/learn/accounts/**")
                                .filters(
                                        f->f.rewritePath("/learn/accounts/(?<remaining>.*)","/${remaining}")
                                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
                                )
                                .uri("http://accounts:8080")
                )
                .route(
                        p->p
                                .path("/learn/cards/**")
                                .filters(
                                        f->f.rewritePath("/learn/cards/(?<remaining>.*)","/${remaining}")
                                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
                                )
                                .uri("http://accounts:9000")
                )
                .route(
                        p->p
                                .path("/learn/loans/**")
                                .filters(
                                        f->f.rewritePath("/learn/loans/(?<remaining>.*)","/${remaining}")
                                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
                                )
                                .uri("http://accounts:8090")
                ).build();


    }
}
