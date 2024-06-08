package com.miu.waaLab.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miu.waaLab.entity.Post;
import com.miu.waaLab.entity.User;
import com.miu.waaLab.entity.dto.response.PostResponseDto;
import com.miu.waaLab.entity.dto.response.UserResponseDto;
import com.miu.waaLab.repository.PostRepository;
import com.miu.waaLab.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelmapper;
@Autowired
private PostRepository postRepository;
    @Override
//    public List<UserResponseDto> findAll() {
//        List<User> listOfUsers = userRepository.findAll();
//        return listOfUsers.stream()
//                .map(u -> modelmapper.map(u, UserResponseDto.class))
//                .collect(Collectors.toList());
//    }
    public List<User> findAll() {
        return userRepository.findAll();
//        return listOfUsers.stream()
//                .map(u -> modelmapper.map(u, UserResponseDto.class))
//                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto findById(long id) {
        return userRepository.findById(id)
                .map(user -> modelmapper.map(user, UserResponseDto.class))
                .orElse(null);
    }

    @Override
    public void save(User u) {
        userRepository.save(u);
        postRepository.saveAll(u.getPosts());

    }

    @Override
    public List<PostResponseDto> findUserPosts(long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return null;
        }
        List<Post> posts = user.getPosts();
        return posts.stream()
                .map(p -> modelmapper.map(p, PostResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<User> getUserEntitiesByPostsCount(int num) {
        return userRepository.getUserEntitiesByPostsCount(num);
    }

}
