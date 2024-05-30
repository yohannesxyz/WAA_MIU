package com.miu.waaLab.entity.dto.request;

import java.util.List;

import com.miu.waaLab.entity.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    private long id;
    private String name;
    private List<PostRequestDto> posts;
}

