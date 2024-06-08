package com.miu.waaLab.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String content;
   private String author;

//   @ManyToOne
//   private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
   private List<Comment> commentList;
    public void addComment(Comment c){
        commentList.add(c);
        c.setPost(this);
    }
}
