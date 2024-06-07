//package com.miu.waaLab.service;
//
//import com.miu.waaLab.entity.Comment;
//import com.miu.waaLab.repository.CommentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class CommentServiceImpl implements ComentService{
//
//    @Autowired
//    private CommentRepository commentRepository;
//
//    @Override
//    public void save(Comment comment) {
//        commentRepository.save(comment);
//    }
//
//    @Override
//    public List<Comment> findAll() {
//        return commentRepository.findAll();
//    }
//
//    @Override
//    public Comment findById(long id) {
//        return commentRepository.findById(id).get();
//    }
//
//    @Override
//    public void delete(Comment comment) {
//commentRepository.delete(comment);
//    }
//
//    @Override
//    public void deleteById(long id) {
//commentRepository.deleteById(id);
//    }
//}
