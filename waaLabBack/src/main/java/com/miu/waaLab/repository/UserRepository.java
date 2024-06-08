package com.miu.waaLab.repository;
import com.miu.waaLab.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long>{

    @Query("SELECT u FROM User u WHERE SIZE(u.posts)> :num ")

    public List<User> getUserEntitiesByPostsCount(int num);


   public User findByEmail(String email);
}
