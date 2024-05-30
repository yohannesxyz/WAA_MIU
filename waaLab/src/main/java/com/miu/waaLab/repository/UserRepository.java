package com.miu.waaLab.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miu.waaLab.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Integer>{


    
}
