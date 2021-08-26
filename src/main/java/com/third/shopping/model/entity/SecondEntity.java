package com.third.shopping.model.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Alias("SecondEntity")
@Getter
@Setter
@Builder
public class SecondEntity {
    private int second_idx;
    private String second_name;
    private int first_idx;
}
