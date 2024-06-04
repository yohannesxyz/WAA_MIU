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
    long id;

    String title;
    String content;
    String author;

    @OneToMany(mappedBy = "post", cascade=CascadeType.ALL)

    private List<Comment> comments;

}
