package com.miu.waaLab.controller;

import com.miu.waaLab.entity.Post;
import com.miu.waaLab.entity.dto.request.PostRequestDto;
import com.miu.waaLab.entity.dto.response.PostResponseDto;
import com.miu.waaLab.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Post p) {
        postService.save(p);

    }
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostResponseDto getById(@PathVariable("id") long id) {
        return postService.findById(id);
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<PostResponseDto> findAll() {
        return postService.findAll();
    }

    @GetMapping("/post/{title}")
    @ResponseStatus(HttpStatus.OK)
    public List<PostResponseDto> findByTitle(@PathVariable("title") String title) {
        return postService.findByTitle(title);
    }

}

