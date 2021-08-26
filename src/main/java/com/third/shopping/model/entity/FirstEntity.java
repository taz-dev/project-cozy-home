package com.third.shopping.model.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Alias("FirstEntity")
@Getter
@Setter
@Builder
public class FirstEntity {

    private int first_idx;
    private String first_name;
    private String src;

}
