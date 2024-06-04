package com.miu.waaLab.service;

import java.util.List;

import com.miu.waaLab.entity.Post;
import com.miu.waaLab.entity.dto.request.PostRequestDto;
import com.miu.waaLab.entity.dto.response.PostResponseDto;


public interface PostService {


public void save(Post p);
public PostResponseDto findById(long id);
public List<PostResponseDto> findAll();

    List<Post> findByTitle(String title);

}
