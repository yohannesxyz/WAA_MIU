package com.miu.waaLab.repository;

import com.miu.waaLab.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepositoryImpl implements PostRepository{

    static List<Post> allPosts;
    static{
        allPosts = new ArrayList<>();
        allPosts.add(new Post(111,"facebook","hello world","john cena"));
        allPosts.add(new Post(222,"twitter","sup","alemitu"));
        allPosts.add(new Post(333,"instagram","howdy","alemayehu"));
        allPosts.add(new Post(444,"telegram","good morning","shegitu"));
    }
    @Override
    public List<Post> findAll() {
        return allPosts;
    }

    @Override
    public Post getById(int id) {
        return allPosts.stream()
                .filter(x->x.getId()==id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Post p) {
allPosts.add(p);
    }
}
