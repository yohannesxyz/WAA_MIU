package com.miu.waaLab.repository;

import com.miu.waaLab.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface PostRepository extends JpaRepository<Post,Long> {

}
