package com.imooc.firstappdemo.config;

import com.imooc.firstappdemo.domain.User;
import com.imooc.firstappdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Flux;

import java.util.Collection;

/**
 * 路由器函数
 */
@Configuration
public class RouterFunctionConfiguration {

    /**
     * 异步非阻塞
     *  person/find/all
     * @param userRepository
     * @return
     */
    @Bean
    @Autowired
    public RouterFunction<ServerResponse> personFindAll(UserRepository userRepository){

        return RouterFunctions.route(RequestPredicates.GET("/person/find/all"),
                request -> {
                    Collection<User> users = userRepository.findAll();
                    Flux<User> userFlux = Flux.fromIterable(users);
                    return ServerResponse.ok().body(userFlux, User.class);
                });
    }
}
