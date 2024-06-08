package com.miu.waaLab.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.miu.waaLab.entity.UserEntity;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity,Long>{

    @Query("SELECT u FROM UserEntity u WHERE SIZE(u.posts)> :num ")

    public List<UserEntity> getUserEntitiesByPostsCount(int num);

    
}
