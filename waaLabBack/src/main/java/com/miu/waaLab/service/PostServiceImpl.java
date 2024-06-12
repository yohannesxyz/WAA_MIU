package com.miu.waaLab.service;

import com.miu.waaLab.entity.Post;
import com.miu.waaLab.entity.dto.request.PostRequestDto;
import com.miu.waaLab.entity.dto.response.PostResponseDto;
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
    ComentService comentService;


    @Autowired
    ModelMapper modelmapper;
    @Override
    public void save(Post p) {

        postrepository.save(p);
    }

    @Override
    public void deleteById(long id) {
        postrepository.deleteById(id);
    }
    @Override
    public PostResponseDto findById(long id) {
        return modelmapper.map(postrepository.findById(id), PostResponseDto.class);
    //    return postrepository.getById(id);
    }

    @Override
    public List<PostResponseDto> findAll() {
        List<Post> posts = postrepository.findAll();
        return posts.stream()
                .map(post -> modelmapper.map(post, PostResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
public void addComment(long postId, String name){
        comentService.addComment(postId,name);
}

    @Override
    public List<Post> findAllByTitle(String title) {
        return postrepository.findAllByTitle(title);
    }

}
