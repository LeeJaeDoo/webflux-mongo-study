package com.wesang.domain.entity.model;

import com.wesang.domain.entity.Post;

import reactor.core.publisher.Mono;

/**
 * @author Jaedoo Lee
 */
public record PostParam(String title, String content) {

    public Post toEntity() {
        return Post.builder()
                   .title(title)
                   .content(content)
                   .build();
    }

}
