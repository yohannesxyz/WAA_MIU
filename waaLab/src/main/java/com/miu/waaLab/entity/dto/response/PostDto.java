package com.miu.waaLab.entity.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class PostDto {
    long id;
    String title;
    String content;
    String author;
}
