package com.miu.waaLab.controller;

import java.util.List;

import com.miu.waaLab.aspect.ExecutionTime;
import com.miu.waaLab.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.miu.waaLab.entity.dto.response.PostResponseDto;
import com.miu.waaLab.entity.dto.response.UserResponseDto;
import com.miu.waaLab.service.UserService;


@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<User> findAll(){
        return userService.findAll();
    }
    @ExecutionTime
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    UserResponseDto findById(@PathVariable("id") long id){
        return userService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteById(@PathVariable long id){
        userService.deleteById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody User u){

        userService.save(u);
    }

    @GetMapping("/{id}/posts")
    @ResponseStatus(HttpStatus.OK)
    public List<PostResponseDto> findUserPosts(@PathVariable("id") int userId){
        return userService.findUserPosts(userId);
    }

    @GetMapping("/users-with-posts/{count}")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUserEntitiesByPostsCount(int count){
        return userService.getUserEntitiesByPostsCount(count);
    }
}
