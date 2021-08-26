package com.third.shopping.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Alias("LoginVO")
@Getter
@Setter
@ToString
public class LoginVO {

    private String id;
    private String pw;

}