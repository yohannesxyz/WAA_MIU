package com.miu.waaLab.repository;

import com.miu.waaLab.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = " INSERT INTO COMMENT (post_id, name) VALUES (:postId,:name) ",nativeQuery = true)

    void addComment(long postId, String name);
}
