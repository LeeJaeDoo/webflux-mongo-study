package com.wesang.application.response;

import com.wesang.domain.entity.Post;

import lombok.Builder;

/**
 * @author Jaedoo Lee
 */
@Builder
public record PostResponse(String postId, String title) {

    public static PostResponse from(Post post) {
        return PostResponse.builder()
                           .postId(post.getId())
                           .title(post.getTitle())
                           .build();
    }

}
