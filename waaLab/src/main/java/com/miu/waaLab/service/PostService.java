package com.miu.waaLab.service;

import com.miu.waaLab.entity.Post;
import com.miu.waaLab.entity.dto.response.PostDto;
import com.miu.waaLab.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface PostService {


public void save(Post p);
public PostDto getById(int id);

public List<PostDto> findAll();

}
