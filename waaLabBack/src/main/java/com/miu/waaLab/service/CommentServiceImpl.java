package com.miu.waaLab.service;

import com.miu.waaLab.entity.Comment;
import com.miu.waaLab.entity.Post;
import com.miu.waaLab.repository.CommentRepository;
import com.miu.waaLab.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements ComentService{

    @Autowired
    private CommentRepository commentRepository;
@Autowired
private PostRepository postRepo;
    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findById(long id) {
        return commentRepository.findById(id).get();
    }

    @Override
    public void delete(Comment comment) {
commentRepository.delete(comment);
    }

    @Override
    public void deleteById(long id) {
commentRepository.deleteById(id);
    }

    @Override
   public void addComment(long postId, String name){

        Post post = postRepo.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        Comment comment = new Comment();
        comment.setName(name);
        post.addComment(comment);
        postRepo.save(post);
    }
}
