package com.miu.waaLab.service;

import com.miu.waaLab.entity.UserEntity;
import com.miu.waaLab.entity.dto.request.UserRequestDto;
import com.miu.waaLab.entity.dto.response.PostResponseDto;
import com.miu.waaLab.entity.dto.response.UserResponseDto;
import java.util.List;
public interface UserService {

    public List<UserResponseDto> findAll();
    public UserResponseDto findById(int id);
    public void save(UserRequestDto u);
    public List<PostResponseDto> findUserPosts(int userId);
}
