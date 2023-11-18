package com.practice.redis.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private String id;
    private String name;
    private Long salary;
}
