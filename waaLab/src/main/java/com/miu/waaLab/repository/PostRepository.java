package com.miu.waaLab.repository;

import com.miu.waaLab.entity.Post;

import java.util.List;

public interface PostRepository {
    public List<Post> findAll();

    public Post getById(int id);

    public void save(Post p);
}
