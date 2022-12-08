package com.spring.bytecode.service;

import com.spring.bytecode.model.Post;

import java.util.List;

public interface PostService {
    public List<Post> validation(List<Post> posts);
}
