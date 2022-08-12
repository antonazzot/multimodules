package apigateway.config;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDiscoveryClient
public class GatewayDiscoveryConfiguration {

//    @Bean
//    public DiscoveryClientRouteDefinitionLocator
//    discoveryClientRouteLocator(DiscoveryClient discoveryClient) {
//        return new DiscoveryClientRouteDefinitionLocator(discoveryClient);
//    }

//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("r1", r -> r.host("**.baeldung.com")
//                        .and()
//                        .path("/baeldung")
//                        .uri("http://baeldung.com"))
//                .route(r -> r.host("**.baeldung.com")
//                        .and()
//                        .path("/myOtherRouting")
//                        .filters(f -> f.prefixPath("/myPrefix"))
//                        .uri("http://othersite.com")
//                        .id("myOtherID"))
//                .build();
//    }
}