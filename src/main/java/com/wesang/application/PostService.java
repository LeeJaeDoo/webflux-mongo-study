package com.wesang.application;

import com.wesang.application.response.PostResponse;
import com.wesang.domain.entity.Post;
import com.wesang.domain.entity.model.PostParam;
import com.wesang.domain.repository.PostRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

/**
 * @author Jaedoo Lee
 */
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;


    public Mono<PostResponse> getPost(String postId) {
        return postRepository.findById(postId)
                             .map(PostResponse::from);
    }

    public Mono<Post> save(PostParam param) {
        return postRepository.save(param.toEntity());
    }

}
