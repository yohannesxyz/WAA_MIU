package com.miu.waaLab.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miu.waaLab.entity.Post;
import com.miu.waaLab.entity.UserEntity;
import com.miu.waaLab.entity.dto.request.UserRequestDto;
import com.miu.waaLab.entity.dto.response.PostResponseDto;
import com.miu.waaLab.entity.dto.response.UserResponseDto;
import com.miu.waaLab.repository.UserRepository;
import com.miu.waaLab.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelmapper;

    @Override
    public List<UserResponseDto> findAll() {
        List<UserEntity> listOfUsers = userRepository.findAll();
        return listOfUsers.stream()
                .map(u -> modelmapper.map(u, UserResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto findById(int id) {
        return userRepository.findById(id)
                .map(user -> modelmapper.map(user, UserResponseDto.class))
                .orElse(null);
    }

    @Override
    public void save(UserRequestDto u) {
        userRepository.save(modelmapper.map(u, UserEntity.class));
    }

    @Override
    public List<PostResponseDto> findUserPosts(int userId) {
        UserEntity user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return null;
        }
        List<Post> posts = user.getPosts();
        return posts.stream()
                .map(p -> modelmapper.map(p, PostResponseDto.class))
                .collect(Collectors.toList());
    }
}
