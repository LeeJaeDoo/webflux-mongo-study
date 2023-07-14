package com.wesang.domain.repository;

import com.wesang.domain.entity.Post;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Jaedoo Lee
 */
public interface PostRepository extends ReactiveMongoRepository<Post, String> {}
