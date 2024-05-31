package com.miu.waaLab.service;

import com.miu.waaLab.entity.UserEntity;
import com.miu.waaLab.entity.dto.request.UserRequestDto;
import com.miu.waaLab.entity.dto.response.PostResponseDto;
import com.miu.waaLab.entity.dto.response.UserResponseDto;
import java.util.List;
public interface UserService {

    public List<UserEntity> findAll();
    public UserResponseDto findById(long id);
    public void save(UserEntity u);
    public List<PostResponseDto> findUserPosts(long userId);
}
