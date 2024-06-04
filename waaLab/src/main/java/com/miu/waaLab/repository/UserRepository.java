package com.miu.waaLab.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.miu.waaLab.entity.UserEntity;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity,Long>{

    UserEntity findAllByIdContaining(Long id);

@Query("SELECT u FROM UserEntity u WHERE SIZE(u.posts) > :postCount")
    List<UserEntity> findByPostsMoreThan(int postCount);


    
}
