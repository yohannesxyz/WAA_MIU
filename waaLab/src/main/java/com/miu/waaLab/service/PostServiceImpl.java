package com.miu.waaLab.service;

import com.miu.waaLab.entity.Post;
import com.miu.waaLab.entity.dto.response.PostDto;
import com.miu.waaLab.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    PostRepository postrepository;

    @Autowired
    ModelMapper modelmapper;
    @Override
    public void save(Post p) {
postrepository.save(p);
    }

    @Override
    public PostDto getById(int id) {
        return modelmapper.map(postrepository.getById(id), PostDto.class);
    //    return postrepository.getById(id);
    }

    @Override
    public List<PostDto> findAll() {
        List<Post> posts = postrepository.findAll();
        return posts.stream()
                .map(post -> modelmapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }


}
