package com.wesang.presentation.router;

import com.wesang.presentation.handler.PostHandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import lombok.RequiredArgsConstructor;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @author Jaedoo Lee
 */
@Configuration
@RequiredArgsConstructor
public class PostRouter {

    private final PostHandler postHandler;

    @Bean
    RouterFunction<ServerResponse> routes() {
        return route().path("/posts", builder ->
                          builder.POST(postHandler::createPost)
                                 .GET("/{id}", postHandler::getPost))
                      .build();
    }

}
