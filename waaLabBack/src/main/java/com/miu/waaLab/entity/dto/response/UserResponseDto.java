package com.miu.waaLab.entity.dto.response;

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
public class UserResponseDto {
 long id;
    String name;
    List<PostResponseDto> posts;
}
