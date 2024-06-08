package com.miu.waaLab.service;

import com.miu.waaLab.entity.User;
import com.miu.waaLab.entity.dto.response.PostResponseDto;
import com.miu.waaLab.entity.dto.response.UserResponseDto;
import java.util.List;
public interface UserService {

    public List<User> findAll();
    public UserResponseDto findById(long id);
    public void save(User u);
    public List<PostResponseDto> findUserPosts(long userId);
    public void deleteById(long userId);
    public List<User> getUserEntitiesByPostsCount(int num);
}
