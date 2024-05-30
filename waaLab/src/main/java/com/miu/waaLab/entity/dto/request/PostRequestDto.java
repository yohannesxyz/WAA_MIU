package com.miu.waaLab.entity.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostRequestDto {
        long id;
        String title;
        String content;
        String author;
        
}
