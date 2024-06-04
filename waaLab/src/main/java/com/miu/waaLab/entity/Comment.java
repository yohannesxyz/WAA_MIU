package com.miu.waaLab.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;

}
