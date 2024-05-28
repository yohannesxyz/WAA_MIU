package com.miu.waaLab.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Post {
    long id;
    String title;
    String content;
    String author;

}
