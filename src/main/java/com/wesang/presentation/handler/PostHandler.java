package com.wesang.presentation.handler;

import com.wesang.application.PostService;
import com.wesang.domain.entity.Post;
import com.wesang.domain.entity.model.PostParam;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebInputException;

import java.net.URI;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Hooks;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.created;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * @author Jaedoo Lee
 */
@Component
@RequiredArgsConstructor
public class PostHandler {

    private final PostService postService;

    public Mono<ServerResponse> createPost(final ServerRequest request) {
        return request.bodyToMono(PostParam.class)
                      .switchIfEmpty(Mono.error(new ServerWebInputException("Request body cannot be empty.")))
                      .flatMap(postService::save)
                      .flatMap(post -> created(URI.create("/posts/" + post.getId())).build());
    }

    public Mono<ServerResponse> getPost(final ServerRequest request) {
        return postService.getPost(request.pathVariable("id"))
                          .flatMap(postResponse -> ok().bodyValue(postResponse));
    }
}
