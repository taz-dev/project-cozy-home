package com.third.shopping.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;
import org.springframework.security.crypto.password.PasswordEncoder;

@Alias("InsertVO")
@Getter
@Setter
@ToString
public class InsertVO {

    private int mem_idx;
    private String id;
    private String pw;
    private String name;
    private String addr;
    private String tel;
    private String addr_detail;


    public void pwEncode(PasswordEncoder passwordEncoder){

        this.pw = passwordEncoder.encode(this.getPw());
    }

}