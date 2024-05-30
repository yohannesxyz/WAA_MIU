package com.miu.waaLab.service;

import java.util.List;

import com.miu.waaLab.entity.dto.request.PostRequestDto;
import com.miu.waaLab.entity.dto.response.PostResponseDto;


public interface PostService {


public void save(PostRequestDto p);
public PostResponseDto findById(int id);
public List<PostResponseDto> findAll();

}
